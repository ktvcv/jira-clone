package hillel.jiraclone.demo.persistence.dao;

import hillel.jiraclone.demo.persistence.common.CommonDao;
import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.dao.interfaces.ICommentDao;
import hillel.jiraclone.demo.persistence.entity.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao extends CommonDao<Comment, Integer> implements ICommentDao {
}
