package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.Comment;
import hillel.jiraclone.demo.persistence.repos.CommentRepo;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends AbstactService<Comment, CommentRepo> {

    public CommentService(CommentRepo repository) {
        super(repository);
    }
}

