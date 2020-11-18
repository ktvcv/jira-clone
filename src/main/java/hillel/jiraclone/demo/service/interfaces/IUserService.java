package hillel.jiraclone.demo.service.interfaces;

import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.entity.User;

import java.util.List;

public interface IUserService extends ICommonDao<User, Integer> {

    User getUserByEmail(String email);
    User getUserByName(String email);

    List<User> getParticipantsInProject(Integer projectId);
    List<User> getParticipantsInProjectAndTheirTasks(Integer projectId);

    User getAllUsersTasksInProject(Integer userId, Integer projectId );
}
