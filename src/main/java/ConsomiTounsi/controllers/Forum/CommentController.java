package ConsomiTounsi.controllers.Forum;

import ConsomiTounsi.Service.CommentManagerInterface;
import ConsomiTounsi.entities.Comment;
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
    public Comment addComment(@RequestBody Comment a){
        Comment comment = commentS.addComment(a);
        return comment ;}

    @GetMapping("/retrieve-all")
    public List<Comment> getListComments(){
        return commentS.retrieveAllComment(); }

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
}
