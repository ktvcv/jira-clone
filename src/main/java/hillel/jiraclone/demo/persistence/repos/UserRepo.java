package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CommonRepo<User, Integer> {

    User getUserByEmail(String email);

    User getUserByName(String email);

    List<User> getParticipantsInProject(Integer projectId);

    List<User> getParticipantsInProjectAndTheirTasks(Integer projectId);
}
