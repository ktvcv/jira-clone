package hillel.jiraclone.demo.service.interfaces;

import hillel.jiraclone.demo.persistence.common.ICommonService;
import hillel.jiraclone.demo.persistence.entity.Task;

import java.util.List;

public interface ITaskService extends ICommonService<Task> {

    List<Task> getAllTasksInProject(Integer projectId);
    List<Task> getAllOpenedTasksInProject(Integer projectId);
    List<Task> getAllTodoTasksInProject(Integer projectId);
    List<Task> getAllToBeApprovedTasksInProject(Integer projectId);
    List<Task> getAllBugsTasksInProject(Integer projectId);
    List<Task> getAllFeatureTasksInProject(Integer projectId);
}
