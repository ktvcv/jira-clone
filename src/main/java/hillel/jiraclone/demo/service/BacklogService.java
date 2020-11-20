package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.dao.BackLogDao;
import hillel.jiraclone.demo.persistence.entity.Backlog;
import hillel.jiraclone.demo.service.interfaces.IBacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BacklogService extends CommonService<Backlog, Integer> implements IBacklogService {

    private final BackLogDao backlogDao;

    @Autowired
    public BacklogService(@Qualifier("backLogDao") ICommonDao<Backlog, Integer> iDao) {
        super(iDao);
        this.backlogDao = (BackLogDao) iDao;
    }
}
