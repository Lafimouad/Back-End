package ConsomiTounsi.Controller.ClaimAndAd;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		return ("<h1> WELCOME TO THE CLAIMANT SERVICES </h1>");
	}
	
	@GetMapping("/findClaim/{id}")
	public Claim FindClaim(@PathVariable("id") Long id){
		return claimManagerI.FindClaim(id);
	
	}
	
	@GetMapping("/getC")
	public List<Claim> getClaims() {
	List<Claim> list = claimManagerI.retrieveAllClaim();
	return list;
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeClaim(@PathVariable("id") Long id) {
	claimManagerI.deleteClaim(id);
	}
	
	@PostMapping("/add")
	public Claim addClaim(@RequestBody Claim C){
		 
		return claimManagerI.addClaim(C) ;	}
	
	@PutMapping("/modify")
	public Claim modifyUser(@RequestBody Claim C) {
	return claimManagerI.updateClaim(C);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*"idClaim" : 5 ,
    "desicion" : null ,
    "date" : 15022020 ,
    "status" : null, 
    "description" : null,
    "subject" : null*/
}
