package hillel.jiraclone.demo.persistence.dao;

import hillel.jiraclone.demo.persistence.common.CommonDao;
import hillel.jiraclone.demo.persistence.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class TaskDao extends CommonDao<Task> {

    public List<Task> getAllTasksCreatedByUser(){
        return Collections.emptyList();
    }

    public List<Task> getAllTasksAssignedToUser(){
        return Collections.emptyList();
    }

    public List<Task> getAllTasksReviewedByUser(){
        return Collections.emptyList();
    }
}
