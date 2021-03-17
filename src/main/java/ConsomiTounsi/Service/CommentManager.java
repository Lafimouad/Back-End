package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Comment;

import java.util.List;
import java.util.Optional;

public class CommentManager implements CommentManagerInterface{
    @Override
    public List<Comment> retrieveAllComment() {
        return null;
    }

    @Override
    public Comment addComment(Comment Co) {
        return null;
    }

    @Override
    public void deleteComment(Long id) {

    }

    @Override
    public void deleteComment(String id) {

    }

    @Override
    public Comment updateComment(Comment Co) {
        return null;
    }

    @Override
    public Optional<Comment> FindComment(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Comment> FindComment(String id) {
        return Optional.empty();
    }
}
