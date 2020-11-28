package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.repos.common.CommonRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CommonRepo<User, Integer> {

//    User getUserByEmail(String email);
//
//    User getUserByName(String email);
}
