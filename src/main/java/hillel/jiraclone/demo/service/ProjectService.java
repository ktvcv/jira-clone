package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.persistence.enumeration.Role;
import hillel.jiraclone.demo.persistence.repos.ProjectRepo;
import hillel.jiraclone.demo.specification.ProjectSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class ProjectService {

    private final ProjectRepo repository;

    @Autowired
    public ProjectService(ProjectRepo commentRepo) {
        this.repository = commentRepo;
    }

    public Project saveOrUpdate(Project entity) {
        Objects.requireNonNull(entity, "You have pass nullable object");
        return repository.save(entity);
    }

    public List<Project> getAll() {
        return repository.findAll();
    }

    public Project get(Integer id) {
        Objects.requireNonNull(id, "Id can not be null");
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void remove(Project entity) {
        Objects.requireNonNull(entity, "You have pass nullable object");
        repository.delete(entity);
    }

    public void removeAll() {
        repository.deleteAll();
    }

    public Page<Project> getAllProjectsByUserUniqueField(String field, Object param, Pageable pageable) {
        Objects.requireNonNull(field, "Unique field can not be null");
        Objects.requireNonNull(param, "Filter parameter can not be null");
        Objects.requireNonNull(pageable, "Pageable object can not be null");

        Page<Project> projects = repository.findAll(ProjectSpec.getAllProjectsByUserUniqueField(field, param), pageable);

        if (projects.hasContent())
            return projects;
        else
            return Page.empty();
    }

    public Page<Project> getAllProjectsWhereUserIsParticipant(String field, Object param, Role role, Pageable pageable) {
        Objects.requireNonNull(field, "Unique field can not be null");
        Objects.requireNonNull(param, "Filter parameter can not be null");
        Objects.requireNonNull(pageable, "Pageable object can not be null");

        Page<Project> projects = repository.findAll(ProjectSpec.getAllProjectWhereUserIsParticipant(field, param, role), pageable);

        if (projects.hasContent())
            return projects;
        else
            return Page.empty();
    }
}
