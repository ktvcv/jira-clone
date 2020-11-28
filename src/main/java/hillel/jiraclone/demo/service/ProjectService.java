package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.ICommonService;
import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService  implements ICommonService<Project> {

    private ProjectRepo projectRepo;

    @Autowired
    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public void saveOrUpdate(Project entity) {

    }

    @Override
    public List<Project> getAll() {
        return null;
    }

    @Override
    public Project get(Integer id) {
        return null;
    }

    @Override
    public void remove(Project entity) {

    }
}
