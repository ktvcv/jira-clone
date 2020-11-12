package hillel.jiraclone.demo.persistence.dao;

import hillel.jiraclone.demo.persistence.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
