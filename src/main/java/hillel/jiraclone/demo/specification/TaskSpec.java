package hillel.jiraclone.demo.specification;

import hillel.jiraclone.demo.persistence.entity.*;
import hillel.jiraclone.demo.persistence.entity.projectsHaveParticipants.UsersInProjects_;
import hillel.jiraclone.demo.persistence.enumeration.Role;
import hillel.jiraclone.demo.persistence.enumeration.TaskStatusApproved;
import hillel.jiraclone.demo.persistence.enumeration.TaskStatusWork;
import hillel.jiraclone.demo.persistence.enumeration.TaskType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class TaskSpec {

    public static Specification<Task> getAllTaskInProjectWithFiltering(Integer backlogId,
                                                                       TaskStatusApproved taskStatusApproved,
                                                                       TaskStatusWork taskStatusWork,
                                                                       TaskType taskType) {
        return (taskRoot, cq, cb) -> {

            Predicate getAll = cb.equal(taskRoot.get(Task_.BACKLOG).get(Backlog_.ID), backlogId);
            return getAll;
        };
    }
}
