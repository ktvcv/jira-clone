package hillel.jiraclone.demo.service;


import hillel.jiraclone.demo.persistence.common.ICommonService;
import hillel.jiraclone.demo.persistence.entity.Backlog;
import hillel.jiraclone.demo.persistence.repos.BacklogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacklogService implements ICommonService<Backlog> {

    private final BacklogRepo backlogRepo;

    @Autowired
    public BacklogService(BacklogRepo backlogRepo) {
        this.backlogRepo = backlogRepo;
    }

    @Override
    public Backlog saveOrUpdate(Backlog entity) {
        return backlogRepo.save(entity);
    }

    @Override
    public List<Backlog> getAll() {
        return backlogRepo.findAll();
    }

    @Override
    public Backlog get(Integer id) {
        return backlogRepo.getOne(id);
    }

    @Override
    public void remove(Backlog entity) {
        backlogRepo.delete(entity);
    }
}
