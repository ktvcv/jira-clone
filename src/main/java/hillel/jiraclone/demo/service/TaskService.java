package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.entity.TaskExtraInfo;
import hillel.jiraclone.demo.persistence.entity.User;
import hillel.jiraclone.demo.persistence.enumeration.Affiliation;
import hillel.jiraclone.demo.persistence.enumeration.TaskFilter;
import hillel.jiraclone.demo.persistence.repos.TaskExtraInfoRepo;
import hillel.jiraclone.demo.persistence.repos.TaskRepo;
import hillel.jiraclone.demo.specification.TaskSpec;
import hillel.jiraclone.demo.specification.UserSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class TaskService {

    private final TaskRepo repository;

    public TaskService(TaskRepo taskRepo) {
        this.repository = taskRepo;
    }

    public Task saveOrUpdate(Task entity) {
        Objects.requireNonNull(entity, "You have pass nullable object");
        return repository.save(entity);
    }

    public List<Task> getAll() {
        return repository.findAll();
    }

    public Task get(Integer id) {
        Objects.requireNonNull(id, "Id can not be null");
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void remove(Task entity) {
        Objects.requireNonNull(entity, "You have pass nullable object");
        repository.delete(entity);
    }

    public void removeAll() {
        repository.deleteAll();
    }

    public Page<Task> getAllUsersTaskInProject(Integer userId,
                                               Integer backlogId,
                                               Pageable pageable,
                                               Set<TaskFilter> filters,
                                               Set<Affiliation> affiliations){
        Objects.requireNonNull(userId, "User id can not be null");
        Objects.requireNonNull(backlogId, "Project id can not be null");
        Objects.requireNonNull(pageable, "Pageable object can not be null");

        Page<Task> tasks = repository.findAll(TaskSpec
                .getAllUsersTaskInProjectWithFiltering(userId,
                        backlogId,
                        new HashSet<>(),
                        new HashSet<>(),
                        new HashSet<>(),
                        new HashSet<>()),
                        pageable);

        if (tasks.hasContent())
            return tasks;
        else
            return Page.empty();
    }
}
