package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.repos.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstactService<User, UserRepo> {

    public UserService(UserRepo repository) {
        super(repository);
    }
}

//@Service
//public class UserService  implements ICommonService<User> {
//
//    private final UserRepo userRepo;
//
//    @Autowired
//    public UserService(final UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }
//
//    @Override
//    public User saveOrUpdate(User entity) {
//        return userRepo.save(entity);
//    }
//
//    @Override
//    public List<User> getAll() {
//        return userRepo.findAll();
//    }
//
//    @Override
//    public User get(Integer id) {
//        return userRepo.getOne(id);
//    }
//
//    @Override
//    public void remove(User entity) {
//        userRepo.delete(entity);
//    }
//
//    @Transactional
//    public boolean changePassword(final User user, final String newPassword) {
//        user.setPassword(newPassword);
//        return true;
//    }
//
//    public boolean checkIfValidNewPassword(final String newPassword, final String confirmPassword) {
//        return newPassword.equals(confirmPassword);
//    }
//
//    public boolean checkIfValidOldPassword(final User user, final String confirmPassword) {
//
//        return (Objects.equals(CipheringService.decrypt(user.getPassword()), confirmPassword));
//
//    }
//
//    public String getUser(final User userFromDB) {
//        return userFromDB.getName() +
//                userFromDB.getEmail();
//    }
//
//    public User getUserByEmail(String email) {
//        return null;
//    }
//
//    public User getUserByName(String name) {
//        //return userRepo.getUserByName(name);
//        return new User();
//    }
//
//    public List<User> getParticipantsInProject(Integer projectId) {
//        return null;
//    }
//
//    public List<User> getParticipantsInProjectAndTheirTasks(Integer projectId) {
//        return null;
//    }
//
//    public User getAllUsersTasksInProject(Integer userId, Integer projectId) {
//        return null;
//    }
//
//    public void addProject(User user, Project project){
//        List<Project> list = user.getProjects();
//        list.add(project);
//        user.setProjects(list);
//    }
//
//    }

