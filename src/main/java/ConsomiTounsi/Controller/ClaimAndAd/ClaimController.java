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


import ConsomiTounsi.Service.ClaimManagerInterface;
import ConsomiTounsi.entities.Claim;


@RestController
@RequestMapping("/Claim")
public class ClaimController {
	
	@Autowired
	ClaimManagerInterface claimManagerI ;
	
	@GetMapping("/home")
	public String Home(){
		return ("WELCOME TO THE CLAIMANT SERVICES");
	}
	
	@GetMapping("/findClaim/{id}")
	public Claim FindClaim(@PathVariable("id") Long id){
		return claimManagerI.FindClaim(id);
	
	}
	
	@GetMapping("/find/{subject}")
	public Optional<Claim> FindBySubject(@PathVariable("subject") String subject){
		return claimManagerI.FindBySubject(subject);
	}
	
	@GetMapping("/getC")
	public List<Claim> getClaims() {
	List<Claim> list = claimManagerI.retrieveAllClaim();
	return list;
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeClaim(@PathVariable("id") Long id) {
	claimManagerI.deleteClaim(id);
	return new ResponseEntity<>("Claim Deleted",HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public Claim addClaim(@RequestBody Claim C){
		 
		return claimManagerI.addClaim(C) ;	}
	
	@PutMapping("/modify")
	public Claim modifyUser(@RequestBody Claim C) {
	return claimManagerI.updateClaim(C);
	}
	
	
	
	
	
	
	
	
	/*"idAdvertisment" : 45 ,
    "nameAdvertisement" : null ,
    "dateAdvertisment" : 444554,
	"enddate" : 55554677 ,
	"finalviews": null,
	"targetviews" : null ,
    "typeAdvertisement" : null ,
	"cost" : null ,
	"channel" : null*/
	
	
	
	
	
	
	/*"idClaim" : 5 ,
    "desicion" : null ,
    "date" : 15022020 ,
    "status" : null, 
    "description" : null,
    "subject" : null*/
}
