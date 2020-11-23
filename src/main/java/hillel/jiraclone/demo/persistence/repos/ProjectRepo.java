package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.persistence.entity.Project_;
import hillel.jiraclone.demo.persistence.entity.User_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public interface ProjectRepo extends CommonRepo<Project, Integer> {

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public default List<Project> getAllUserProjectById(Integer id) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Project> cq = cb.createQuery(Project.class);
//
//        Root<Project> root = cq.from(Project.class);
//        root.fetch(Project_.USER, JoinType.LEFT);
//
//        cq.where(cb.equal(root.get(Project_.USER).get(User_.ID), id));
//
//        return entityManager.createQuery(cq).getResultList();
//    }

}
