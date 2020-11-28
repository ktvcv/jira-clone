package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.ICommonService;
import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.repos.TaskRepo;
import hillel.jiraclone.demo.persistence.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ICommonService<Task> {

    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(final TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public void saveOrUpdate(Task entity) {

    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public Task get(Integer id) {
        return null;
    }

    @Override
    public void remove(Task entity) {

    }
}
