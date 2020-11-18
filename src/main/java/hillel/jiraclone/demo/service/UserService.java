package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.util.CipheringService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class UserService  {

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

}
