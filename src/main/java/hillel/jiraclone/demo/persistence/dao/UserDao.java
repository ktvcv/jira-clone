package hillel.jiraclone.demo.persistence.dao;

import hillel.jiraclone.demo.persistence.common.CommonDao;
import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.entity.User_;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class UserDao extends CommonDao<User> {


    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {
        return super.getEntityByField(User_.EMAIL,email);
    }

    @Transactional(readOnly = true)
    public User getUserByName(String name) {
        return super.getEntityByField(User_.NAME, name);
    }

}
