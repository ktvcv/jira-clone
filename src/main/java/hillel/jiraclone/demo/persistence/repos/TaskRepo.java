package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.repos.common.CommonRepository;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface TaskRepo extends CommonRepository<Task> {
}
