package ConsomiTounsi.Controller.ClaimAndAd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ConsomiTounsi.Service.AdvertisementManagerInterface;
import ConsomiTounsi.entities.Advertisement;

import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.TypeCategory;


@RestController
@RequestMapping("/Ad")
public class AdController {
	
	
	@Autowired
	AdvertisementManagerInterface admanagerI ;
	
	
	@GetMapping("/home")
	public String Home(){
		return ("WELCOME TO THE ADVERTISEMENT");
	}
	
	@GetMapping("/findAd/{id}")
	public Advertisement FindAdvertisement(@PathVariable("id") Long id){
		return admanagerI.FindAdvertisement(id);
	
	}
	
	@GetMapping("/getC")
	public List<Advertisement> getAdvertisements() {
	List<Advertisement> list = admanagerI.retrieveAllAdvertisement();
	return list;
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeAdvertisement(@PathVariable("id") Long id) {
		admanagerI.deleteAdvertisement(id);
	return new ResponseEntity<>("The Ad HAS BEEN DELETED ",HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public Advertisement addAd(@RequestBody Advertisement Ad){
		 
		return admanagerI.addAdvertisement(Ad) ;	}
	
	@PutMapping("/modify")
	public Advertisement modifyAd(@RequestBody Advertisement Ad) {
	return admanagerI.updateAdvertisement( Ad);
	}
	
	//@PutMapping("/modifyChannel")
	//public Advertisement modifyChannel(@PathVariable Long id, @RequestBody Advertisement Ad) {
	//return admanagerI.modifyChannel(id ,Ad);
	//}
	
	/////////////////////
	
	
	/*@GetMapping("/getCat/{cp}")
	public List<Product> FindAdvertisementFemale(@PathVariable("cp") TypeCategory cp){
		return admanagerI.showAdvertsementByCategoryFemale(cp);
	
	
}*/
	
	
	@GetMapping("/getCat2")
	public List<Product> FindAdvertisement( TypeCategory cp){
		
		
		return admanagerI.showAdvertsementByCategory(cp);
	
}
	
	
}