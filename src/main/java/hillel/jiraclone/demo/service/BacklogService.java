package hillel.jiraclone.demo.service;


import hillel.jiraclone.demo.persistence.entity.Backlog;
import hillel.jiraclone.demo.persistence.repos.BacklogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class BacklogService {

    private final BacklogRepo repository;

    @Autowired
    public BacklogService(BacklogRepo backlogRepo) {
        this.repository = backlogRepo;
    }

    public Backlog saveOrUpdate(Backlog entity) {
        Assert.notNull(entity, "You have pass nullable object");
        return repository.save(entity);
    }

    public List<Backlog> getAll() {
        return repository.findAll();
    }

    public Backlog get(Integer id) {
        Assert.notNull(id, "Id can not be null");
        return repository.getOne(id);
    }

    public void remove(Backlog entity) {
        Assert.notNull(entity, "You have pass nullable object");
        repository.delete(entity);
    }

    public void removeAll(){
        repository.deleteAll();
    }
}
