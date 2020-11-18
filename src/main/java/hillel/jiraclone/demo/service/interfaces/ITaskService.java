package hillel.jiraclone.demo.service.interfaces;

import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.entity.Task;

import java.util.List;

public interface ITaskService extends ICommonDao<Task, Integer> {

    List<Task> getAllTasksInProject(Integer projectId);
}
