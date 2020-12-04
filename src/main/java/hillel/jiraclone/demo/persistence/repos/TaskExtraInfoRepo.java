package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.TaskExtraInfo;
import hillel.jiraclone.demo.service.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskExtraInfoRepo extends CommonRepository<TaskExtraInfo> {
}
