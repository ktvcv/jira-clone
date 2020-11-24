package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends CommonRepo<Comment> {
}
