package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.ICommonService;
import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.repos.ProjectRepo;
import hillel.jiraclone.demo.persistence.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService  extends AbstactService<Project, ProjectRepo>{

    public ProjectService(ProjectRepo repository) {
        super(repository);
    }
}
