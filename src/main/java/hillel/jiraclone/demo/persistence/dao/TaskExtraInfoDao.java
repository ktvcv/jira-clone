package hillel.jiraclone.demo.persistence.dao;

import hillel.jiraclone.demo.persistence.common.CommonDao;
import hillel.jiraclone.demo.persistence.dao.interfaces.ITaskExtraInfoDao;
import hillel.jiraclone.demo.persistence.entity.TaskExtraInfo;
import org.springframework.stereotype.Repository;

@Repository
public class TaskExtraInfoDao extends CommonDao<TaskExtraInfo, Integer> implements ITaskExtraInfoDao {
}
