package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.enumeration.Affiliation;
import hillel.jiraclone.demo.persistence.enumeration.Role;
import hillel.jiraclone.demo.persistence.repos.TaskRepo;
import hillel.jiraclone.demo.persistence.repos.UserRepo;
import hillel.jiraclone.demo.persistence.util.CipheringService;
import hillel.jiraclone.demo.specification.UserSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

@Service
public class UserService  {

    private final UserRepo repository;

    public UserService(UserRepo userRepo) {
        this.repository = userRepo;
    }
    @Transactional
    public User saveOrUpdate(User entity) {
        Assert.notNull(entity, "You have pass nullable object");
        return repository.save(entity);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public User get(Integer id) {
        Assert.notNull(id, "Id can not be null");
        return repository.getOne(id);
    }

    @Transactional
    public void remove(User entity) {
        Assert.notNull(entity, "You have pass nullable object");
        repository.delete(entity);
    }

    @Transactional
    public void removeAll() {
        repository.deleteAll();
    }


    @Transactional(readOnly = true)
    public Page<User> getAllUsersInProject(Integer projectId, Role role, Pageable pageable){
        Assert.notNull(projectId, "Project id can not be null");
        Assert.notNull(pageable, "Pageable object can not be null");

        Page<User> users = repository.findAll(UserSpec.getAllUsersInProject(projectId, role), pageable);

        if(users.hasContent())
            return users;
        else
            return Page.empty();
    }

    public Page<User> getAllUserRelatedWithTask(Integer taskId, Affiliation affiliation, Pageable pageable){
        Assert.notNull(taskId, "Project id can not be null");
        Assert.notNull(affiliation, "Pageable object can not be null");

        Page<User> users = repository.findAll(UserSpec.getAllUsersRelateWithTask(taskId, affiliation), pageable);

        if(users.hasContent())
            return users;
        else
            return Page.empty();
    }



    @Transactional
    public void changePassword(final User user, final String newPassword) {
        Assert.notNull(user, "User is  null");
        Assert.notNull(newPassword, "New password can not be null");
        user.setPassword(newPassword);
        repository.save(user);
    }

    public boolean checkIfValidNewPassword(final String newPassword, final String confirmPassword) {
        Assert.notNull(newPassword, "New password is null");
        Assert.notNull(confirmPassword, "New password confirmation is null");
        return newPassword.equals(confirmPassword);
    }

    public boolean checkIfValidOldPassword(final User user, final String confirmPassword) {
        Assert.notNull(user, "User object is null");
        Assert.notNull(confirmPassword, "New password confirmation is null");

        return (Objects.equals(CipheringService.decrypt(user.getPassword()), confirmPassword));

    }
}

