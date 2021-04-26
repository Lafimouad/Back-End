package ConsomiTounsi.controllers.accounts;

import ConsomiTounsi.Service.DelivererManagerInterface;
import ConsomiTounsi.entities.Deliverer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliverer")
public class DelivererController {

    @Autowired
    DelivererManagerInterface delivererS;

    @PutMapping("/update")
    public void updateDeliverer(@RequestBody Deliverer a , @RequestParam("password") String password){
         delivererS.updateDeliverer(a , password);
    }

}
