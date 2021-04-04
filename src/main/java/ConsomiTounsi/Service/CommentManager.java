package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Client;
import ConsomiTounsi.entities.Comment;
import ConsomiTounsi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CommentManager implements CommentManagerInterface{

    @Autowired
    CommentRepository cr;

    @Override
    public List<Comment> retrieveAllComment() {
        return (List<Comment>) cr.findAll();
    }

    @Override
    public Comment addComment(Comment Co) {
        return cr.save(Co);
    }

    @Override
    public void deleteComment(Long id) {
        cr.deleteById(id);
    }

    @Override
    public void deleteComment(String id) {
        cr.deleteById(Long.parseLong(id));
    }

    @Override
    public Comment updateComment(Comment Co) {
        return cr.save(Co);
    }

    @Override
    public Comment FindComment(Long id) {
        return  cr.findById(id).orElse(new Comment());    }

    @Override
    public Comment FindComment(String id) {
        return  cr.findById(Long.parseLong(id)).orElse(new Comment());    }

    @Override
    public List<Comment> retrieveCommentByPertinence(boolean mostPertinentComment) {
        return cr.retrieveCommentByPertinence(mostPertinentComment);
    }

    @Transactional
    public void like(long id) {
        Comment c = cr.findById(id).get();
        int x = c.getLikesComment();
        c.setLikesComment(x++);
    }

    public void pertinatingComment(){
        
    }
}
