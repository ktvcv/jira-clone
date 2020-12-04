package hillel.jiraclone.demo.specification;

import hillel.jiraclone.demo.persistence.entity.Project_;
import hillel.jiraclone.demo.persistence.entity.Task_;
import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.entity.User_;
import hillel.jiraclone.demo.persistence.entity.projectsHaveParticipants.UsersInProjects_;
import hillel.jiraclone.demo.persistence.entity.usersHaveTasks.UsersWithTasks_;
import hillel.jiraclone.demo.persistence.enumeration.Affiliation;
import hillel.jiraclone.demo.persistence.enumeration.Role;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class UserSpec {

    public static Specification<User> getAllUsersInProject(Integer projectId, Role role) {
        return (userRoot, cq, cb) -> {

            Predicate getAll = cb.equal(userRoot.get(User_.IN_PROJECTS).get(UsersInProjects_.PROJECT).get(Project_.ID), projectId);
            Predicate withRole = cb.and(cb.equal(userRoot.get(User_.IN_PROJECTS).get(UsersInProjects_.ROLE), role),
                    cb.isNotNull(userRoot.get(User_.IN_PROJECTS).get(UsersInProjects_.ROLE)));

            if (role == null)
                return getAll;
            else
                return cb.and(getAll, withRole);
        };
    }

    public static Specification<User> getAllUsersRelateWithTask(Integer taskId, Affiliation affiliation) {
        return (userRoot, cq, cb) -> {

            Predicate getAll = cb.equal(userRoot.get(User_.TASKS).get(UsersWithTasks_.TASK).get(Task_.ID), taskId);
            Predicate withAffiliation = cb.and(cb.equal(userRoot.get(User_.TASKS).get(UsersWithTasks_.AFFILIATION), affiliation),
                    cb.isNotNull(userRoot.get(User_.TASKS).get(UsersWithTasks_.AFFILIATION)));

            if (affiliation == null)
                return getAll;
            else return cb.and(getAll, withAffiliation);
        };
    }
}
