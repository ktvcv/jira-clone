package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.common.ICommonService;
import hillel.jiraclone.demo.persistence.entity.Comment;
import hillel.jiraclone.demo.persistence.entity.Task;
import hillel.jiraclone.demo.persistence.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommonService<Comment> {

    private CommentRepo commentRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment saveOrUpdate(Comment entity) {
        return commentRepo.save(entity);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment get(Integer id) {
        return commentRepo.getOne(id);
    }

    @Override
    public void remove(Comment entity) {
        commentRepo.delete(entity);
    }
}

