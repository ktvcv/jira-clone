package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.dao.ProjectDao;
import hillel.jiraclone.demo.persistence.dao.SprintDao;
import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.persistence.entity.Sprint;
import hillel.jiraclone.demo.service.interfaces.ISprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SprintService extends CommonService<Sprint, Integer> implements ISprintService {

    private final SprintDao sprintDao;

    @Autowired
    public SprintService(@Qualifier("sprintDao") ICommonDao<Sprint, Integer> iDao) {
        super(iDao);
        this.sprintDao = (SprintDao) iDao;
    }

}
