package hillel.jiraclone.demo.service;

import com.sun.istack.NotNull;
import hillel.jiraclone.demo.persistence.entity.Comment;
import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.persistence.enumeration.Role;
import hillel.jiraclone.demo.persistence.repos.CommentRepo;
import hillel.jiraclone.demo.persistence.repos.ProjectRepo;
import hillel.jiraclone.demo.specification.ProjectSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepo repository;

    @Autowired
    public ProjectService(ProjectRepo commentRepo) {
        this.repository = commentRepo;
    }

    public Project saveOrUpdate(Project entity) {
        Assert.notNull(entity, "You have pass nullable object");
        return repository.save(entity);
    }

    public List<Project> getAll() {
        return repository.findAll();
    }

    public Project get(Integer id) {
        Assert.notNull(id, "Id can not be null");
        return repository.getOne(id);
    }

    public void remove(Project entity) {
        Assert.notNull(entity, "You have pass nullable object");
        repository.delete(entity);
    }

    public void removeAll(){
        repository.deleteAll();
    }

    public Page<Project> getAllProjectsByUserUniqueField(String field, Object param, Pageable pageable){
        Assert.notNull(field, "Unique field can not be null");
        Assert.notNull(param, "Filter parameter can not be null");
        Assert.notNull(pageable, "Pageable object can not be null");

        Page<Project> projects = repository.findAll(ProjectSpec.getAllProjectsByUserUniqueField(field,param), pageable);

        if(projects.hasContent())
            return projects;
        else
            return Page.empty();
    }

    public Page<Project> getAllProjectsWhereUserIsParticipant(String field, Object param, Role role, Pageable pageable){
        Assert.notNull(field, "Unique field can not be null");
        Assert.notNull(param, "Filter parameter can not be null");
        Assert.notNull(pageable, "Pageable object can not be null");

        Page<Project> projects = repository.findAll(ProjectSpec.getAllProjectWhereUserIsParticipant(field, param, role), pageable);

        if(projects.hasContent())
            return projects;
        else
            return Page.empty();
    }
}
