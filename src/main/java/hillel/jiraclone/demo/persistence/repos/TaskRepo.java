package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends CommonRepo<Task> {

//    @Query
//    List<Task> getAllTasksCreatedByUserId(Integer userId);
//
//    List<Task> getAllTasksAssignedToUser();
//
//    List<Task> getAllTasksReviewedByUser();
}
