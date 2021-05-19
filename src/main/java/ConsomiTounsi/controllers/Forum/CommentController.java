package ConsomiTounsi.controllers.Forum;

import ConsomiTounsi.Service.CommentManagerInterface;
import ConsomiTounsi.entities.Comment;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Forum/Comment")
public class CommentController {

    @Autowired
    CommentManagerInterface commentS;

    @PutMapping("/add/{id}")
    public void addComment(@RequestBody Comment a, @PathVariable("id") long  id){ commentS.addComment(a , id);}

    @GetMapping("/retrieve-all")
    public List<Comment> getListComments(){ return commentS.retrieveAllComment(); }

    @GetMapping("/retrieve-id")
    public Comment getCommentById(@RequestParam("id") long id){
        return commentS.FindComment(id);
    }

    @DeleteMapping("remove-id/{id}")
    public void removeCommentByID(@PathVariable("id")long id){
        commentS.deleteComment(id);
    }

    @PutMapping("/update")
    public Comment updateComment(@RequestBody Comment a){
        return commentS.updateComment(a);
    }

    @PutMapping("/likeComment-id/{id}")
    public void addLike(@PathVariable("id") long id){commentS.addLike(id);}

    @PutMapping("/dislikeComment-id/{id}")
    public void dislike(@PathVariable("id") long id){commentS.dislike(id);}

    @GetMapping("/mostPertinentComments/{id}")
    public Comment GetPertinentCommentsBySubject(@PathVariable("id") long id){
        return commentS.retrieveCommentByPertinence(id); }

    @PutMapping("/pertinentComments")
    public void updatePertinent(){
        commentS.setPertinentComments();
    }

    @GetMapping("/retrieveSubjectComments-idSubject/{id}")
    public Set<Comment> retrieveSubjectComments(@PathVariable("id") long id){
        return commentS.retrieveSubjectComments(id);
    }

}
