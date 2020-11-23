package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.Sprint;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepo extends CommonRepo<Sprint, Integer>  {
}
