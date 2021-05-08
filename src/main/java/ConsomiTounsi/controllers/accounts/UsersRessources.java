package ConsomiTounsi.controllers.accounts;

import ConsomiTounsi.Service.AdminManagerInterface;
import ConsomiTounsi.Service.ClientManagerInterface;
import ConsomiTounsi.Service.DelivererManagerInterface;
import ConsomiTounsi.Service.UserManagerInterface;
import ConsomiTounsi.entities.Deliverer;
import ConsomiTounsi.entities.Role;
import ConsomiTounsi.entities.User;
import ConsomiTounsi.entities.UserRole;
import ConsomiTounsi.repository.AdminRepository;
import ConsomiTounsi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/ressources/user")
@CrossOrigin(origins = "*")
@RestController
public class UsersRessources {

    @Autowired
    ClientManagerInterface cs;

    @Autowired
    AdminManagerInterface as;

    @Autowired
    DelivererManagerInterface ds;

    @Autowired
    UserManagerInterface us;

    @Autowired
    UserRepository ur;

    @Autowired
    AdminRepository ar;

    @GetMapping("/countClients")
    public long NbClients(){
        return cs.getNombreClient();
    }

    @GetMapping("/countAdmins")
    public long NbAdmins(){
        return as.getNbAdmin();
    }

    @GetMapping("/countDeliverers")
    public long NbDeliverers() {return ds.getNbDeliverer();}

    @GetMapping("/countManagers")
    public long NbManagers() { return us.getNbManagers();}

    @GetMapping("/delivererOftheMonth")
    public String getFirstAndLastNameofDelivofMonth(){
        Deliverer d = ds.getDelivererOfTheMonth();
        String s = d.getFirstNameUser() + " " + d.getLastNameUser() ;
        return s ; }

    @GetMapping(value="/clientOftheMonth" , produces = "application/json")
    public String getFirstAndLastNameofClientofMonth(){
        return us.getClientOftheMonth();
    }

    @GetMapping("/available")
    public long getAvailableDeliveres()
    {return ds.getNbAvailableDeliveres();}

    @GetMapping("/notavailable")
    public long getNotAvailableDeliveres()
    {return ds.getNbNotAvailableDeliveres();}

    @GetMapping("/nbAAccounts")
    public long getAAccounts()
    {return ar.getNbAdminByRole(Role.ACCOUNTS_MANAGER);}

    @GetMapping("/nbAAds")
    public long getAAds()
    {return ar.getNbAdminByRole(Role.ADVERTISEMENTS_MANAGER);}

    @GetMapping("/nbAClaims")
    public long getAClaims()
    {return ar.getNbAdminByRole(Role.CLAIMS_MANAGER);}

    @GetMapping("/nbADeliveries")
    public long getADeliveries()
    {return ar.getNbAdminByRole(Role.DELIVERIES_MANAGER);}

    @GetMapping("/nbAProducts")
    public long getAProducts()
    {return ar.getNbAdminByRole(Role.PRODUCTS_MANAGER);}

    @GetMapping("/nbAEvents")
    public long getAEvents()
    {return ar.getNbAdminByRole(Role.EVENT_MANAGER);}


}
