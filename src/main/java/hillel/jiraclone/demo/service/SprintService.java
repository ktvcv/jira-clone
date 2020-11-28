package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.ICommonService;
import hillel.jiraclone.demo.persistence.entity.Sprint;
import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.repos.SprintRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService implements ICommonService<Sprint> {

    private final SprintRepo sprintRepo;

    @Autowired
    public SprintService(SprintRepo sprintRepo) {
        this.sprintRepo = sprintRepo;
    }

    @Override
    public Sprint saveOrUpdate(Sprint entity) {
       return sprintRepo.save(entity);
    }

    @Override
    public List<Sprint> getAll() {
        return sprintRepo.findAll();
    }

    @Override
    public Sprint get(Integer id) {
        return sprintRepo.getOne(id);
    }

    @Override
    public void remove(Sprint entity) {
        sprintRepo.delete(entity);
    }
}
