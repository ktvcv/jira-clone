package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.entity.Sprint;
import hillel.jiraclone.demo.persistence.repos.SprintRepo;
import hillel.jiraclone.demo.service.interfaces.ISprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SprintService extends CommonService<Sprint, SprintRepo> implements ISprintService {

    @Autowired
    public SprintService(SprintRepo repository) {
        super(repository);
    }
}
