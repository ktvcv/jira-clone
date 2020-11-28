package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.ICommonService;
import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.entity.TaskExtraInfo;
import hillel.jiraclone.demo.persistence.repos.TaskExtraInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskExtraService implements ICommonService<TaskExtraInfo> {

    private TaskExtraInfoRepo taskExtraInfoRepo;

    @Autowired
    public TaskExtraService(TaskExtraInfoRepo taskExtraInfoRepo) {
        this.taskExtraInfoRepo = taskExtraInfoRepo;
    }

    @Override
    public TaskExtraInfo saveOrUpdate(TaskExtraInfo entity) {
        return taskExtraInfoRepo.save(entity);
    }

    @Override
    public List<TaskExtraInfo> getAll() {
        return taskExtraInfoRepo.findAll();
    }

    @Override
    public TaskExtraInfo get(Integer id) {
        return taskExtraInfoRepo.getOne(id);
    }

    @Override
    public void remove(TaskExtraInfo entity) {
        taskExtraInfoRepo.delete(entity);
    }
}
