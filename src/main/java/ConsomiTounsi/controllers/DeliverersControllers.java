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

import ConsomiTounsi.Service.DelivererManagerInterface;
import ConsomiTounsi.entities.Deliverer;

public class DeliverersControllers {
	@Autowired
	DelivererManagerInterface DevlivererManI ;
	
	@GetMapping("/firstpage")
	public String First(){
		return ("<h1> First Delivery </h1>");
	}
	@GetMapping("/findD/{id}")
	public Optional<Deliverer> getDevliverer(@PathVariable("id") long id){
		return DevlivererManI.FindDelivererById(id);
	}
	
	@GetMapping("/getD")
	public List<Deliverer> getDeliverer() {
	List<Deliverer> list = DevlivererManI.retrieveAllDeliverer();
	return list;
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeDeliverer(@PathVariable("id") long id) {
		DevlivererManI.deleteDelivererById(id);
	}
	
	@PostMapping("/addDev")
	public Deliverer addDeliverer(@RequestBody Deliverer D){
		 
		return DevlivererManI.addDeliverer(D) ;	}
	
	@PutMapping("/modify")
	public Deliverer modifyDeliverer(@RequestBody Deliverer D) {
	return DevlivererManI.updateDeliverer(D);
	}
	
	@GetMapping("/MaxScore")
	public Long getMaxOfScore() {
		return DevlivererManI.FindMaxScore();
	}
}
