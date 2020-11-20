package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.dao.CommentDao;
import hillel.jiraclone.demo.persistence.dao.TaskExtraInfoDao;
import hillel.jiraclone.demo.persistence.entity.Comment;
import hillel.jiraclone.demo.persistence.entity.TaskExtraInfo;
import hillel.jiraclone.demo.service.interfaces.ICommentService;
import hillel.jiraclone.demo.service.interfaces.ITaskExtraInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TaskExtraService extends CommonService<TaskExtraInfo, Integer> implements ITaskExtraInfoService {

    private final TaskExtraInfoDao taskExtraInfoDao;

    @Autowired
    public TaskExtraService(@Qualifier("taskExtraInfoDao") ICommonDao<TaskExtraInfo, Integer> iDao) {
        super(iDao);
        this.taskExtraInfoDao = (TaskExtraInfoDao) iDao;
    }
}
