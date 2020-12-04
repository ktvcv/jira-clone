package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.Backlog;
import hillel.jiraclone.demo.persistence.repos.common.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepo extends CommonRepository<Backlog> {
}
