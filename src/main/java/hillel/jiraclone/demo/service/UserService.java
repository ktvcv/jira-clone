package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.enumeration.Affiliation;
import hillel.jiraclone.demo.persistence.enumeration.Role;
import hillel.jiraclone.demo.persistence.repos.UserRepo;
import hillel.jiraclone.demo.persistence.util.CipheringService;
import hillel.jiraclone.demo.specification.UserSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private final UserRepo repository;

    public UserService(UserRepo userRepo) {
        this.repository = userRepo;
    }

    @Transactional
    public User saveOrUpdate(User entity) {
        Objects.requireNonNull(entity, "You have pass nullable object");
        return repository.save(entity);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public User get(Integer id) {
        Objects.requireNonNull(id, "Id can not be null");
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void remove(User entity) {
        Objects.requireNonNull(entity, "You have pass nullable object");
        repository.delete(entity);
    }

    @Transactional
    public void removeAll() {
        repository.deleteAll();
    }


    @Transactional(readOnly = true)
    public Page<User> getAllUsersInProject(Integer projectId, Role role, Pageable pageable) {
        Objects.requireNonNull(projectId, "Project id can not be null");
        Objects.requireNonNull(pageable, "Pageable object can not be null");

        Page<User> users = repository.findAll(UserSpec.getAllUsersInProject(projectId, role), pageable);

        if (users.hasContent())
            return users;
        else
            return Page.empty();
    }

    public Page<User> getAllUserRelatedWithTask(Integer taskId, Affiliation affiliation, Pageable pageable) {
        Objects.requireNonNull(taskId, "Task id can not be null");
        Objects.requireNonNull(affiliation, "Pageable object can not be null");

        Page<User> users = repository.findAll(UserSpec.getAllUsersRelateWithTask(taskId, affiliation), pageable);

        if (users.hasContent())
            return users;
        else
            return Page.empty();
    }

    @Transactional
    public void changePassword(final User user, final String newPassword) {
        Objects.requireNonNull(user, "User is  null");
        Objects.requireNonNull(newPassword, "New password can not be null");
        user.setPassword(newPassword);
        repository.save(user);
    }

    public boolean checkIfValidNewPassword(final String newPassword, final String confirmPassword) {
        Objects.requireNonNull(newPassword, "New password is null");
        Objects.requireNonNull(confirmPassword, "New password confirmation is null");
        return newPassword.equals(confirmPassword);
    }

    public boolean checkIfValidOldPassword(final User user, final String confirmPassword) {
        Objects.requireNonNull(user, "User object is null");
        Objects.requireNonNull(confirmPassword, "New password confirmation is null");

        return (Objects.equals(CipheringService.decrypt(user.getPassword()), confirmPassword));

    }
}

