package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.dao.ProjectDao;
import hillel.jiraclone.demo.persistence.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collections;
import java.util.List;

@Service
public class ProjectService {

    private ProjectDao projectDao;

    @Autowired
    public ProjectService(final ProjectDao projectDao) {
        this.projectDao = projectDao;
        this.projectDao.setAClass(Project.class);
    }

    @Transactional(readOnly = true)
    public List<Project> getAllUserProjectByUserName(Integer id){
        return Collections.emptyList();
    }

    @Transactional(readOnly = true)
    public List<Project> getAllUserProjectByUserId(Integer id){
        return projectDao.getAllUserProjectById(id);
    }

    @Transactional(readOnly = true)
    public List<Project> getProjectsWhereUserIsParticipantByName(String userName){
        return Collections.emptyList();
    }
}
