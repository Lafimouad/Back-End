package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Comment;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CommentManagerInterface {
    List<Comment> retrieveAllComment();
    void addComment(Comment Co);
    void deleteComment(Long id);
    void deleteComment(String id);
    Comment updateComment(Comment Co);
    Comment FindComment(Long id);
    Comment FindComment(String id);

    int addLike(long id);
    List<Comment> retrieveCommentByPertinence(long id);
    List<Comment> retrieveSubjectComments(long id);

    void setPertinentComments();

}
