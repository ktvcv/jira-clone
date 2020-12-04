package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.Comment;
import hillel.jiraclone.demo.persistence.repos.common.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends CommonRepository<Comment> {
}
