package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.dao.UserDao;
import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.util.CipheringService;
import hillel.jiraclone.demo.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class UserService extends CommonService<User, Integer> implements IUserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("userDao") ICommonDao<User, Integer> iDao) {
        super(iDao);
        this.userDao = (UserDao) iDao;
    }

    @Transactional
    public boolean changePassword(final User user, final String newPassword) {
        user.setPassword(newPassword);
        return true;
    }

    public boolean checkIfValidNewPassword(final String newPassword, final String confirmPassword) {
        return newPassword.equals(confirmPassword);
    }

    public boolean checkIfValidOldPassword(final User user, final String confirmPassword) {

        return (Objects.equals(CipheringService.decrypt(user.getPassword()), confirmPassword));

    }

    public String getUser(final User userFromDB) {
        return userFromDB.getName() +
                userFromDB.getEmail();
    }

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

    @Override
    public User getAllUsersTasksInProject(Integer userId, Integer projectId) {
        return null;
    }

    public void addProject(User user, Project project){
        List<Project> list = user.getProjects();
        list.add(project);
        user.setProjects(list);
    }
}
