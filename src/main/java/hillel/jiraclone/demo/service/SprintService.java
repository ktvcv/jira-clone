package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.Sprint;
import hillel.jiraclone.demo.persistence.repos.SprintRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class SprintService {

    private final SprintRepo repository;

    public SprintService(SprintRepo commentRepo) {
        this.repository = commentRepo;
    }

    public Sprint saveOrUpdate(Sprint entity) {
        Objects.requireNonNull(entity, "You have pass nullable object");

        return repository.save(entity);
    }

    public List<Sprint> getAll() {
        return repository.findAll();
    }

    public Sprint get(Integer id) {
        Objects.requireNonNull(id, "Id can not be null");

        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void remove(Sprint entity) {
        Objects.requireNonNull(entity, "You have pass nullable object");

        repository.delete(entity);
    }

    public void removeAll() {
        repository.deleteAll();
    }
}
