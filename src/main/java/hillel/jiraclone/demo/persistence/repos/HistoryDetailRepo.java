package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.HistoryDetails;
import hillel.jiraclone.demo.persistence.repos.common.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryDetailRepo extends CommonRepository<HistoryDetails> {
}
