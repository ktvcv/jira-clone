package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.repos.common.CommonRepo;
import hillel.jiraclone.demo.service.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CommonRepository<User> {

}
