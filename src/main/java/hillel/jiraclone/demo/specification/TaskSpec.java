package hillel.jiraclone.demo.specification;

import hillel.jiraclone.demo.persistence.entity.Backlog_;
import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.entity.Task_;
import hillel.jiraclone.demo.persistence.entity.User_;
import hillel.jiraclone.demo.persistence.entity.usersHaveTasks.UsersWithTasks_;
import hillel.jiraclone.demo.persistence.enumeration.Affiliation;
import hillel.jiraclone.demo.persistence.enumeration.TaskStatusApproved;
import hillel.jiraclone.demo.persistence.enumeration.TaskStatusWork;
import hillel.jiraclone.demo.persistence.enumeration.TaskType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.util.Set;

public class TaskSpec {

    public static Specification<Task> getAllTaskWithFiltering(String belongToName,
                                                              String belongToIdName,
                                                              Integer idOfBelonged,
                                                              Set<TaskStatusApproved> taskStatusApproves,
                                                              Set<TaskStatusWork> taskStatusWorks,
                                                              Set<TaskType> taskTypes,
                                                              Set<Affiliation> affiliations) {
        return (taskRoot, cq, cb) -> {

            Predicate getAll = cb.equal(taskRoot.get(belongToName).get(belongToIdName), idOfBelonged);
            Predicate finalPredicate = cb.and(getAll);

            CriteriaBuilder.In<TaskStatusApproved> inClauseApproved = cb.in(taskRoot.get(Task_.STATUS_APPROVED));
            CriteriaBuilder.In<TaskStatusWork> inClauseStatusWork = cb.in(taskRoot.get(Task_.STATUS_WORK));
            CriteriaBuilder.In<TaskType> inClauseTaskType = cb.in(taskRoot.get(Task_.TYPE));

            //first filter on approved status of task
            for (TaskStatusApproved statusApproved : taskStatusApproves)
                inClauseApproved.value(statusApproved);

            if (!taskStatusApproves.isEmpty())
                finalPredicate = cb.and(finalPredicate, inClauseApproved);

            //filter on type of task
            for (TaskType eTaskType : taskTypes)
                inClauseTaskType.value(eTaskType);

            if (!taskTypes.isEmpty())
                finalPredicate = cb.and(finalPredicate, inClauseTaskType);

            //filter on status of work of task
            for (TaskStatusWork statusWork : taskStatusWorks)
                inClauseStatusWork.value(statusWork);

            if (!taskStatusWorks.isEmpty())
                finalPredicate = cb.and(finalPredicate, inClauseStatusWork);

            //filter affiliation of user-task
            for (TaskStatusWork statusWork : taskStatusWorks)
                inClauseStatusWork.value(statusWork);

            if (!taskStatusWorks.isEmpty())
                finalPredicate = cb.and(finalPredicate, inClauseStatusWork);


            return finalPredicate;
        };
    }

    //TODO: refactoring types of tasks -> to one set
    public static Specification<Task> getAllUsersTaskInProjectWithFiltering(Integer userId,
                                                              Integer backlogId,
                                                              Set<TaskStatusApproved> taskStatusApproves,
                                                              Set<TaskStatusWork> taskStatusWorks,
                                                              Set<TaskType> taskTypes,
                                                              Set<Affiliation> affiliations) {
        return (taskRoot, cq, cb) -> {
            Predicate getAllByUser = cb.equal(taskRoot.get(Task_.USERS).get(UsersWithTasks_.USER).get(User_.ID), userId);

            Predicate finalPredicate = getAllByUser;

            Predicate getByProjectFiltered = getAllTaskWithFiltering(Task_.BACKLOG, Backlog_.ID, backlogId,
                    taskStatusApproves, taskStatusWorks,
                    taskTypes, affiliations).toPredicate(taskRoot, cq, cb);

            finalPredicate = cb.and(finalPredicate, getByProjectFiltered);

            CriteriaBuilder.In<Affiliation> inClauseAffiliation = cb.in(taskRoot.get(Task_.USERS).get(UsersWithTasks_.AFFILIATION));

            //filter affiliation of user-task
            for (Affiliation affiliation : affiliations)
                inClauseAffiliation.value(affiliation);

            if (!affiliations.isEmpty())
                finalPredicate = cb.and(finalPredicate, inClauseAffiliation);

            return cb.and(getAllByUser, getByProjectFiltered);
        };
    }

}
