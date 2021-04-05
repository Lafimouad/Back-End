package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Client;
import ConsomiTounsi.entities.Comment;
import ConsomiTounsi.entities.Subject;
import ConsomiTounsi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class CommentManager implements CommentManagerInterface{

    @Autowired
    SubjectManagerInterface subjectS;

    @Autowired
    CommentRepository cr;

    @Override
    public List<Comment> retrieveAllComment() {
        return (List<Comment>) cr.findAll();
    }

    @Override
    public void addComment(Comment Co) {
        boolean prohibited = false;
        List<String> prohibitedDict = Arrays.asList("fuck", "shit", "bastard", "bitch");
        List<String> List = new ArrayList<String>(Arrays.asList(Co.getTextComment().split("\\s+")));
        for (String word : List ) {
            if (prohibitedDict.contains(word)){ prohibited = true ;}}
        if (prohibited == false )
        { Co.setLikesComment(0);
        cr.save(Co);} }

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
    public List<Comment> retrieveCommentByPertinence(long id){
        return cr.retrievePertinentCommentsBySubject(id);
    }

    @Override
    public List<Comment> retrieveSubjectComments(long id) {
        return cr.retrieveSubjectComments(id);
    }

    @Override
    public void setPertinentComments() {
        int MaxLikes=0;
        long idMax = 0 ;
        List<Subject> ListSubjects = subjectS.retrieveAllSubject();
        for ( Subject subj : ListSubjects) {
            Set<Comment> ListComments = subj.getComment();
            for ( Comment c : ListComments) {
                if ( c.getLikesComment() > MaxLikes )
                    {
                        MaxLikes = c.getLikesComment();
                        idMax = c.getIdComment();
                    }
            }
                cr.setPertinentComment(idMax);
        }
    }

    @Override
    public int addLike(long id) {
        Comment a = cr.findById(id).orElse(new Comment());
        int nb = a.getLikesComment() + 1;
        return cr.addLike(nb , id) ; }



}
