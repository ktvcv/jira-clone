package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.repos.ProjectRepo;
import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.service.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends CommonService<Project, ProjectRepo> implements IProjectService {

    public ProjectService(ProjectRepo repository) {
        super(repository);
    }
}
