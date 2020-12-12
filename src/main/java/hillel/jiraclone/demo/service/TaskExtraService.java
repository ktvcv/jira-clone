package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.TaskExtraInfo;
import hillel.jiraclone.demo.persistence.repos.TaskExtraInfoRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class TaskExtraService {

    private final TaskExtraInfoRepo repository;

    public TaskExtraService(TaskExtraInfoRepo commentRepo) {
        this.repository = commentRepo;
    }

    public TaskExtraInfo saveOrUpdate(TaskExtraInfo entity) {
        Objects.requireNonNull(entity, "You have pass nullable object");
        return repository.save(entity);
    }

    public List<TaskExtraInfo> getAll() {
        return repository.findAll();
    }

    public TaskExtraInfo get(Integer id) {
        Objects.requireNonNull(id, "Id can not be null");
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void remove(TaskExtraInfo entity) {
        Objects.requireNonNull(entity, "You have pass nullable object");
        repository.delete(entity);
    }

    public void removeAll() {
        repository.deleteAll();
    }
}
