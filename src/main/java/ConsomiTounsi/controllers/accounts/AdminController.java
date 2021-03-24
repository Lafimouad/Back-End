package ConsomiTounsi.controllers.accounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ConsomiTounsi.Service.AdminManagerInterface;
import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Role;

//http://localhost:8081/SpringMVC/servlet/accounts/admin.............................
@RestController
@RequestMapping("/accounts/admin")
public class AdminController {
	
	@Autowired
	AdminManagerInterface adminS; 
	
	/*{
    "idUser": 1,
    "firstNameUser": null,
    "lastNameUser": null,
    "usernameUser": null,
    "passwordUser": null,
    "phoneNumberUser": null,
    "emailAddressUser": null,
    "dateBirthUser": null,
    "addressUser": null,
    "roleAdmin": "PRODUCTS_MANAGER"}
    */
	
	@PostMapping("/add")
	public Admin addAdmin(@RequestBody Admin a){
		Admin admin = adminS.addAdmin(a);
		return admin ;	}
	
	@GetMapping("/retrieve-all")
	public List<Admin> getListAdmins(){
	return adminS.retrieveAllAdmin(); }
	
	@GetMapping("/retrieve-id")
	public Admin getAdminById(@RequestParam("id") long id){
		return adminS.FindAdminById(id);
	}
	
	@DeleteMapping("remove-id")
	public void removeAdminByID(@RequestParam("id")long id){
		adminS.deleteAdminById(id);
	}
	
	@PutMapping("/update")
	public Admin updateAdmin(@RequestBody Admin a){
		return adminS.updateAdmin(a);
	}
	
	@GetMapping("/retrive-role")
	public List<Admin> getAdminsbyRole(@RequestParam("role") Role role ){ 
		return adminS.FindAdminByRole(role);}

}
