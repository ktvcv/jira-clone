package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.repos.TaskRepo;
import hillel.jiraclone.demo.service.interfaces.ITaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService extends CommonService<Task> implements ITaskService {

    public TaskService(TaskRepo repository) {
        super(repository);
    }

    @Override
    public List<Task> getAllTasksInProject(Integer projectId) {
        return null;
    }

    @Override
    public List<Task> getAllOpenedTasksInProject(Integer projectId) {
        return null;
    }

    @Override
    public List<Task> getAllTodoTasksInProject(Integer projectId) {
        return null;
    }

    @Override
    public List<Task> getAllToBeApprovedTasksInProject(Integer projectId) {
        return null;
    }

    @Override
    public List<Task> getAllBugsTasksInProject(Integer projectId) {
        return null;
    }

    @Override
    public List<Task> getAllFeatureTasksInProject(Integer projectId) {
        return null;
    }
}
