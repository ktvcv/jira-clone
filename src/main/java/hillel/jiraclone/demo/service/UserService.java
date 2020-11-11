package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.dao.UserDao;
import hillel.jiraclone.demo.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserDao userDao;

    @Autowired
    private final CipheringService cipheringService;

    public UserService(@Autowired UserDao userDao, @Autowired CipheringService cipheringService) {
        this.userDao = userDao;
        this.cipheringService = cipheringService;
    }

    @Transactional
    public boolean changePassword(final User user, final String oldPassword, final String newPassword)
    {
        if(cipheringService.decrypt(user.getPassword()).equals(oldPassword)){
            user.setPassword(newPassword);
            userDao.update(user);
            return true;
        }
        return false;
    }

    public String getUser(final User userFromDB){
        return userFromDB.getName() +
                userFromDB.getEmail();
              //TODO: cipheringService.userFromDB.getPassword();
            //Может для пароля сделать какой-то отдельный PasswordEncoder?
    }

    public List<User> getForPage(int start, int number){
        return userDao.list(start, number);
    }




}
