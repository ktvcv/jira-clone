package hillel.jiraclone.demo.persistence.dao;

import hillel.jiraclone.demo.persistence.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void persist(final User user) {
        Assert.notNull(user, "user entity must be a set");
        entityManager.persist(user);
    }

    public void update(final User user) {
        Assert.notNull(user, "user entity must be a set");
        entityManager.merge(user);
    }

    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }

    public void delete(User user) {
        entityManager.remove(user);
    }

    public List<User> list(int start, int pageSize) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        CriteriaQuery<User> selectForPage = criteriaQuery.select(root);
        TypedQuery<User> typedQuery = entityManager.createQuery(selectForPage);
        typedQuery.setFirstResult(start);
        typedQuery.setMaxResults(pageSize);
        return typedQuery.getResultList();

    }

}
