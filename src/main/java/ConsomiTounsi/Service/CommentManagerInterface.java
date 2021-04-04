package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Comment;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CommentManagerInterface {
    List<Comment> retrieveAllComment();
    Comment addComment(Comment Co);
    void deleteComment(Long id);
    void deleteComment(String id);
    Comment updateComment(Comment Co);
    Comment FindComment(Long id);
    Comment FindComment(String id);
    //fct bich tzid ka3ba like
    void like(long id);
    @Transactional
    List<Comment> retrieveCommentByPertinence(boolean mostPertinentComment);

}
