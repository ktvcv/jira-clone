package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.entity.Backlog;
import hillel.jiraclone.demo.persistence.repos.CommonRepo;
import hillel.jiraclone.demo.service.interfaces.IBacklogService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BacklogService extends CommonService<Backlog> implements IBacklogService {

    public BacklogService(@Qualifier("backLogRepo") CommonRepo<Backlog> repository) {
        super(repository);
    }
}
