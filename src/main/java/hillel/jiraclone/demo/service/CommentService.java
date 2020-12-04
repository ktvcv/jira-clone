package hillel.jiraclone.demo.service;

import hillel.jiraclone.demo.persistence.entity.Backlog;
import hillel.jiraclone.demo.persistence.entity.Comment;
import hillel.jiraclone.demo.persistence.repos.BacklogRepo;
import hillel.jiraclone.demo.persistence.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepo repository;

    @Autowired
    public CommentService(CommentRepo commentRepo) {
        this.repository = commentRepo;
    }

    public Comment saveOrUpdate(Comment entity) {
        Assert.notNull(entity, "You have pass nullable object");
        return repository.save(entity);
    }

    public List<Comment> getAll() {
        return repository.findAll();
    }

    public Comment get(Integer id) {
        Assert.notNull(id, "Id can not be null");
        return repository.getOne(id);
    }

    public void remove(Comment entity) {
        Assert.notNull(entity, "You have pass nullable object");
        repository.delete(entity);
    }

    public void removeAll(){
        repository.deleteAll();
    }
}

