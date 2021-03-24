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

import ConsomiTounsi.Service.DelivererManagerInterface;
import ConsomiTounsi.entities.Deliverer;

@RestController
@RequestMapping("/accounts/deliverer")
public class DelivererController {

	@Autowired
	DelivererManagerInterface delivererS;
	
	/*{
    "idUser": 8,
    "firstNameUser": "sarra",
    "lastNameUser": "beddey",
    "usernameUser": null,
    "passwordUser": null,
    "phoneNumberUser": null,
    "emailAddressUser": null,
    "dateBirthUser": null,
    "addressUser": null,
    "delivererOfTheMonthDeliverer": false,
    "availableDeliverer": false,
    "distanceDeliverer": 0.0,
    "bonusDeliverer": 0.0}*/
	
	@PostMapping("/add")
	public Deliverer addDeliverer(@RequestBody Deliverer a){
		Deliverer deliverer = delivererS.addDeliverer(a);
		return deliverer ;	}
	
	@GetMapping("/retrieve-all")
	public List<Deliverer> getListDeliverers(){
	return delivererS.retrieveAllDeliverer(); }
	
	@GetMapping("/retrieve-id")
	public Deliverer getDelivererById(@RequestParam("id") long id){
		return delivererS.FindDelivererById(id);
	}
	
	@DeleteMapping("remove-id")
	@Modifying
	public void removeClientByID(@RequestParam("id")long id){
		delivererS.deleteDelivererById(id);
	}
	
	@PutMapping("/update")
	@Modifying
	public Deliverer updateDeliverer(@RequestBody Deliverer a){
		return delivererS.updateDeliverer(a);
	}
}
