package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.entity.Backlog;
import hillel.jiraclone.demo.persistence.repos.BackLogRepo;
import hillel.jiraclone.demo.persistence.repos.CommonRepo;
import hillel.jiraclone.demo.service.interfaces.IBacklogService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BacklogService extends CommonService<Backlog, BackLogRepo> implements IBacklogService {

    public BacklogService(BackLogRepo repository) {
        super(repository);
    }
}
