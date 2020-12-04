package hillel.jiraclone.demo.service;


import hillel.jiraclone.demo.persistence.entity.Backlog;
import hillel.jiraclone.demo.persistence.repos.BacklogRepo;
import org.springframework.stereotype.Service;

@Service
public class BacklogService extends AbstactService<Backlog, BacklogRepo> {

    public BacklogService(BacklogRepo repository) {
        super(repository);
    }
}
