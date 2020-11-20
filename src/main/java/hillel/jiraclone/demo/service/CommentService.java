package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.dao.CommentDao;
import hillel.jiraclone.demo.persistence.entity.Comment;
import hillel.jiraclone.demo.service.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends CommonService<Comment, Integer> implements ICommentService {

    private final CommentDao commentDao;

    @Autowired
    public CommentService(@Qualifier("commentDao") ICommonDao<Comment, Integer> iDao) {
        super(iDao);
        this.commentDao = (CommentDao) iDao;
    }
}
