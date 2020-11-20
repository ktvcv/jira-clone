package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.dao.TaskDao;
import hillel.jiraclone.demo.persistence.dao.UserDao;
import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.service.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService extends CommonService<Task, Integer> implements ITaskService {

    private final TaskDao taskDao;

    @Autowired
    public TaskService(@Qualifier("taskDao") ICommonDao<Task, Integer> iDao) {
        super(iDao);
        this.taskDao = (TaskDao) iDao;
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
