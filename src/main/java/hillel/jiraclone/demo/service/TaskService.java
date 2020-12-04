package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.repos.TaskRepo;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends AbstactService<Task, TaskRepo> {

    public TaskService(TaskRepo repository) {
        super(repository);
    }
}
