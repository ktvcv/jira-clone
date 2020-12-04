package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.Sprint;
import hillel.jiraclone.demo.persistence.repos.SprintRepo;
import org.springframework.stereotype.Service;

@Service
public class SprintService extends AbstactService<Sprint, SprintRepo> {

    public SprintService(SprintRepo repository) {
        super(repository);
    }
}
