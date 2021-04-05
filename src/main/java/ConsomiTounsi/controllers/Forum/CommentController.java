package ConsomiTounsi.controllers.Forum;

import ConsomiTounsi.Service.CommentManagerInterface;
import ConsomiTounsi.entities.Comment;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Forum/Comment")
public class CommentController {

    /*{
    "idComment": 1,
    "likesComment": 2,
    "prohibitedDictComment": false,
    "mostPertinatComment": false,
    "subject": null
}*/

    @Autowired
    CommentManagerInterface commentS;

    @PostMapping("/add")
    public void addComment(@RequestBody Comment a){ commentS.addComment(a);}

    @GetMapping("/retrieve-all")
    public List<Comment> getListComments(){ return commentS.retrieveAllComment(); }

    @GetMapping("/retrieve-id")
    public Comment getCommentById(@RequestParam("id") long id){
        return commentS.FindComment(id);
    }

    @DeleteMapping("remove-id")
    public void removeCommentByID(@RequestParam("id")long id){
        commentS.deleteComment(id);
    }

    @PutMapping("/update")
    public Comment updateComment(@RequestBody Comment a){
        return commentS.updateComment(a);
    }

    @PutMapping("/likeComment-id")
    public void addLike(@RequestParam("id") long id){commentS.addLike(id);}

    @GetMapping("/mostPertinentComments")
    public List<Comment> GetPertinentCommentsBySubject(@RequestParam("id") long id){
        return commentS.retrieveCommentByPertinence(id); }

    @PutMapping("/pertinentComments")
    public void updatePertinent(){
        commentS.setPertinentComments();
    }

    @GetMapping("/retrieveSubjectComments-idSubject")
    public List<Comment> retrieveSubjectComments(@RequestParam("id") long id){
        return commentS.retrieveSubjectComments(id);
    }

}
