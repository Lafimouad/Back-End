package ConsomiTounsi.controllers.ShelfStoreProduct;


import ConsomiTounsi.Service.ShelfManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shelf")
public class ShelfController {
    @Autowired
    ShelfManagerInterface shelfmanager ;


    @GetMapping("/home")
    public String Home(){
        return ("<h1> WELCOME TO THE SHELF SERVICES </h1>");
    }

    @GetMapping("/findShelf/{type}")
    public Claim FindClaim(@PathVariable("id") Long id){
        return claimManagerI.FindClaim(id);

    }



}
