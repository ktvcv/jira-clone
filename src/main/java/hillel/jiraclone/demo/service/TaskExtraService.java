package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.TaskExtraInfo;
import hillel.jiraclone.demo.persistence.repos.TaskExtraInfoRepo;
import org.springframework.stereotype.Service;

@Service
public class TaskExtraService extends AbstactService<TaskExtraInfo, TaskExtraInfoRepo> {

    public TaskExtraService(TaskExtraInfoRepo repository) {
        super(repository);
    }
}
