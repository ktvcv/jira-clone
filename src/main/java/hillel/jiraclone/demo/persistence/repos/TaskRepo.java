package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends CommonRepo<Task, Integer> {

    List<Task> getAllTasksCreatedByUser();

    List<Task> getAllTasksAssignedToUser();

    List<Task> getAllTasksReviewedByUser();
}
