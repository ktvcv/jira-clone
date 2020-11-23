package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.Backlog;
import org.springframework.stereotype.Repository;

@Repository
public interface BackLogRepo extends CommonRepo<Backlog, Integer> {

}
