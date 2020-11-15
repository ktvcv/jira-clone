package hillel.jiraclone.demo.persistence.dao;

import hillel.jiraclone.demo.persistence.common.CommonDao;
import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.persistence.entity.Project_;
import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.entity.User_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

@Repository
public class ProjectDao extends CommonDao<Project> {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Project> getAllUserProjectByName(String userName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Project> cq = cb.createQuery(Project.class);

        Root<Project> root = cq.from(Project.class);
        root.fetch(Project_.USER, JoinType.LEFT);

        cq.where(cb.equal(root.get(Project_.USER).get(User_.NAME), userName));

        return entityManager.createQuery(cq).getResultList();
    }

    public List<User> getParticipantsInProject(Integer projectId){
        return Collections.emptyList();
    }

}
