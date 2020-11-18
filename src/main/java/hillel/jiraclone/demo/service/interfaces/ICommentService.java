package hillel.jiraclone.demo.service.interfaces;

import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.entity.Comment;

public interface ICommentService extends ICommonDao<Comment,Integer> {
}
