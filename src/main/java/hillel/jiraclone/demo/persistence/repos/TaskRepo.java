package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.repos.common.CommonRepo;
import hillel.jiraclone.demo.service.CommonRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TaskRepo extends CommonRepository<Task> {

    List<Task> findAll(Specification<Task> specification);
}
