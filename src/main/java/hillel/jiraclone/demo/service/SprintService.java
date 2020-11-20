package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.entity.Sprint;
import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.service.interfaces.ISprintService;
import hillel.jiraclone.demo.service.interfaces.ITaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService extends CommonService<Sprint, Integer> implements ISprintService {

}
