package hillel.jiraclone.demo.service.interfaces;

import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.common.ICommonService;
import hillel.jiraclone.demo.persistence.entity.Task;

import java.util.List;

public interface ITaskService extends ICommonService<Task, Integer> {

    List<Task> getAllTasksInProject(Integer projectId);
}
