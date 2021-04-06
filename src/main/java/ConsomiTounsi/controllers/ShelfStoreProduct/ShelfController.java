package ConsomiTounsi.controllers.ShelfStoreProduct;


import ConsomiTounsi.Service.ShelfManagerInterface;
import ConsomiTounsi.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelf")
public class ShelfController {
    @Autowired
    ShelfManagerInterface shelfmanager ;


    @GetMapping("/home")
    public String Home(){
        return ("<h1> WELCOME TO THE SHELF SERVICES </h1>");
    }

    @PostMapping("/add")
    public void addShelf(@RequestBody Shelf s){ commentS.addComment(a);}

    @GetMapping("/retrieve-all")
    public List<Comment> getListShelfs(){ return commentS.retrieveAllComment(); }

    @GetMapping("/retrieve-id")
    public Comment getShelfById(@RequestParam("id") long id){
        return commentS.FindComment(id);
    }

    @DeleteMapping("remove-id")
    public void removeShelfByID(@RequestParam("id")long id){
        commentS.deleteComment(id);
    }

    @PutMapping("/update")
    public Comment updateShelf(@RequestBody Comment a){
        return commentS.updateComment(a);
    }

    /*@PutMapping("/likeComment-id")
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


}*/



}
