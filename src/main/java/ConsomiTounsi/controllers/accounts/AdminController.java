package ConsomiTounsi.controllers.accounts;

import ConsomiTounsi.Service.AdminManagerInterface;
import ConsomiTounsi.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminManagerInterface adminS;

    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin a){
        return adminS.updateAdmin(a);
    }
}
