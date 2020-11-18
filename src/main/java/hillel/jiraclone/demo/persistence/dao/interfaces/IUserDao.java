package hillel.jiraclone.demo.persistence.dao.interfaces;

import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.entity.User_;

import java.util.Collections;
import java.util.List;

public interface IUserDao extends ICommonDao<User, Integer> {

    public User getUserByEmail(String email);
    public User getUserByName(String email);

    public List<User> getParticipantsInProject(Integer projectId);
    public List<User> getParticipantsInProjectAndTheirTasks(Integer projectId);
}
