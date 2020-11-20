package hillel.jiraclone.demo.persistence.dao;

import hillel.jiraclone.demo.persistence.common.CommonDao;
import hillel.jiraclone.demo.persistence.dao.interfaces.IUserDao;
import hillel.jiraclone.demo.persistence.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends CommonDao<User, Integer> implements IUserDao {

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserByName(String email) {
        return null;
    }

    @Override
    public List<User> getParticipantsInProject(Integer projectId) {
        return null;
    }

    @Override
    public List<User> getParticipantsInProjectAndTheirTasks(Integer projectId) {
        return null;
    }
}
