package hillel.jiraclone.demo.specification;

import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.persistence.entity.Project_;
import hillel.jiraclone.demo.persistence.entity.projectsHaveParticipants.UsersInProjects_;
import hillel.jiraclone.demo.persistence.enumeration.Role;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

public class ProjectSpec {

    public static Specification<Project> getAllProjectsByUserUniqueField(String field, Object par) {

        return (projectRoot, cq, cb) -> {
            projectRoot.fetch(Project_.USER, JoinType.LEFT);
            return cb.equal(projectRoot.get(Project_.USER).get(field), par);
        };
    }


    public static Specification<Project> getAllProjectWhereUserIsParticipant(String uniqueUserField, Object par, Role role) {

        return (projectRoot, cq, cb) -> {
            cq.distinct(true);

            Predicate getAll = cb.equal(projectRoot.get(Project_.PARTICIPANTS).get(UsersInProjects_.USER).get(uniqueUserField), par);
            Predicate withAffiliation = cb.and(cb.equal(projectRoot.get(Project_.PARTICIPANTS).get(UsersInProjects_.ROLE), role),
                    cb.isNotNull(projectRoot.get(Project_.PARTICIPANTS).get(UsersInProjects_.ROLE)));


            if (role == null)
                return getAll;
            else
                return cb.and(getAll, withAffiliation);
        };
    }
}
