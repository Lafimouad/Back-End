package ConsomiTounsi.controllers.accounts;

import ConsomiTounsi.Service.DelivererManagerInterface;
import ConsomiTounsi.entities.Deliverer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliverer")
public class DelivererController {

    @Autowired
    DelivererManagerInterface delivererS;

    @PutMapping("/update")
    public Deliverer updateDeliverer(@RequestBody Deliverer a){
        return delivererS.updateDeliverer(a);
    }

}
