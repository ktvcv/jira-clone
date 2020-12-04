package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.entity.TaskExtraInfo;
import hillel.jiraclone.demo.persistence.repos.TaskExtraInfoRepo;
import hillel.jiraclone.demo.persistence.repos.TaskRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepo repository;

    public TaskService(TaskRepo taskRepo) {
        this.repository = taskRepo;
    }

    public Task saveOrUpdate(Task entity) {
        Assert.notNull(entity, "You have pass nullable object");
        return repository.save(entity);
    }

    public List<Task> getAll() {
        return repository.findAll();
    }

    public Task get(Integer id) {
        Assert.notNull(id, "Id can not be null");
        return repository.getOne(id);
    }

    public void remove(Task entity) {
        Assert.notNull(entity, "You have pass nullable object");
        repository.delete(entity);
    }

    public void removeAll() {
        repository.deleteAll();
    }
}
