package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.dao.UserDao;
import hillel.jiraclone.demo.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    @Transactional
    public boolean changePassword(final User user, final String newPassword) {
        user.setPassword(newPassword);
        userDao.update(user);
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


    public Page<User> getForPage(int page, int size) {
        return userDao.listPageable(PageRequest.of(page, size));
    }


}
