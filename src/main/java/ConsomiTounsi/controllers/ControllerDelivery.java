package ConsomiTounsi.controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ConsomiTounsi.Service.DeliveryManagerInterface;
import ConsomiTounsi.entities.Delivery;

@RestController
@RequestMapping("/Delivery")
public class ControllerDelivery {
	@Autowired
	DeliveryManagerInterface DevliveryI ;
	
	@GetMapping("/firstage")
	public String First(){
		return ("<h1> First Delivery </h1>");
		}
	@GetMapping("/find/{id}")
	public Optional<Delivery> getDevlivery(@PathVariable("id") long id){
		return DevliveryI .FindDelivery(id);
	}
	
	@GetMapping("/get")
	public List<Delivery> getDelivery() {
	List<Delivery> list = DevliveryI.retrieveAllDelivery();
	return list;
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeDelivery(@PathVariable("id") long id) {
		DevliveryI .deleteDelivery(id);
	}
	
	@PostMapping("/add")
	public Delivery addDelivery(@RequestBody Delivery De){
		 
		return DevliveryI.addDelivery(De) ;	}
	
	@PutMapping("/modify")
	public Delivery modifyDelivery(@RequestBody Delivery De) {
	return DevliveryI.updateDelivery(De);
	}

}
