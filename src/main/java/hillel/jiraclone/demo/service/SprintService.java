package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.Sprint;
import hillel.jiraclone.demo.persistence.repos.SprintRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class SprintService {

    private final SprintRepo repository;

    public SprintService(SprintRepo commentRepo) {
        this.repository = commentRepo;
    }

    public Sprint saveOrUpdate(Sprint entity) {
        Assert.notNull(entity, "You have pass nullable object");
        return repository.save(entity);
    }

    public List<Sprint> getAll() {
        return repository.findAll();
    }

    public Sprint get(Integer id) {
        Assert.notNull(id, "Id can not be null");
        return repository.getOne(id);
    }

    public void remove(Sprint entity) {
        Assert.notNull(entity, "You have pass nullable object");
        repository.delete(entity);
    }

    public void removeAll() {
        repository.deleteAll();
    }
}
