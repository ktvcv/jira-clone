package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.Sprint;
import hillel.jiraclone.demo.persistence.repos.common.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepo extends CommonRepository<Sprint> {
}
