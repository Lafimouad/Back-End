package ConsomiTounsi.controllers.ShelfStoreProduct;


import ConsomiTounsi.Service.ShelfManagerInterface;
import ConsomiTounsi.entities.Comment;
import ConsomiTounsi.entities.Shelf;
import ConsomiTounsi.entities.typeShelf;
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
    public void addShelf(@RequestBody Shelf s){ shelfmanager.addShelf(s);}

    @GetMapping("/retrieve-all")
    public List<Shelf> getListShelves(){ return shelfmanager.retrieveAllShelf(); }

    @GetMapping("/retrieve-id")
    public Shelf getShelfById(@RequestParam("id") long id){
        return shelfmanager.FindShelf(id);
    }

    @DeleteMapping("remove-id")
    public void removeShelfByID(@RequestParam("id")long id){
        shelfmanager.deleteShelf(id);
    }

    @PutMapping("/update")
    public Shelf updateShelf(@RequestBody Shelf p){
        return shelfmanager.updateShelf(p);
    }

    @PutMapping("/TypeShelf")
    public void FindByTypeShelf(@RequestParam("typeShelf") typeShelf TypeShelf){shelfmanager.FindByTypeShelf(TypeShelf);}

    /*@GetMapping("/mostPertinentComments")
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
