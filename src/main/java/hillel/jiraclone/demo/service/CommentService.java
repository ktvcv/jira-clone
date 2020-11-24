package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.CommonService;
import hillel.jiraclone.demo.persistence.entity.Comment;
import hillel.jiraclone.demo.persistence.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends CommonService<Comment, CommentRepo> {

    public CommentService(CommentRepo repository) {
        super(repository);
    }
}

