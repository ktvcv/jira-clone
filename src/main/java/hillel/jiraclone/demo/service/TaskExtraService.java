package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.entity.TaskExtraInfo;
import hillel.jiraclone.demo.persistence.repos.TaskExtraInfoRepo;
import hillel.jiraclone.demo.service.interfaces.ITaskExtraInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskExtraService extends CommonService<TaskExtraInfo, TaskExtraInfoRepo> implements ITaskExtraInfoService {

    @Autowired
    public TaskExtraService(TaskExtraInfoRepo repository) {
        super(repository);
    }
}
