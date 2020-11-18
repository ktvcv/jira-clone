package hillel.jiraclone.demo.persistence.dao;

import hillel.jiraclone.demo.persistence.common.CommonDao;
import hillel.jiraclone.demo.persistence.dao.interfaces.IBacklogDao;
import hillel.jiraclone.demo.persistence.entity.Backlog;
import org.springframework.stereotype.Repository;

@Repository
public class BackLogDao extends CommonDao<Backlog, Integer> implements IBacklogDao {

}
