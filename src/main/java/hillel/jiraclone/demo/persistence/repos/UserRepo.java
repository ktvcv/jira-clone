package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    User getUserByEmail(String email);

    User getUserByName(String email);

//    List<User> getParticipantsInProject(Integer projectId);
//
//    List<User> getParticipantsInProjectAndTheirTasks(Integer projectId);
}
