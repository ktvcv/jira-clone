package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.dao.ProjectDao;
import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.service.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends CommonService<Project, Integer> implements IProjectService {

    private final ProjectDao projectDao;

    @Autowired
    public ProjectService(@Qualifier("projectDao") ICommonDao<Project, Integer> iDao) {
        super(iDao);
        this.projectDao = (ProjectDao) iDao;
    }

}
