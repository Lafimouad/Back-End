package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentManagerInterface {
    List<Comment> retrieveAllComment();
    Comment addComment(Comment Co);
    void deleteComment(Long id);
    void deleteComment(String id);
    Comment updateComment(Comment Co);
    Optional<Comment> FindComment(Long id);
    Optional<Comment> FindComment(String id);
}
