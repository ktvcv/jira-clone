package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.dao.ProjectDao;
import hillel.jiraclone.demo.persistence.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Transactional(readOnly = true)
    public List<Project> getAllUserProject(String userName){
        return projectDao.getAllUserProjectByName(userName);
    }
}
