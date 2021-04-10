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
	
	
	@GetMapping("/find/{status}")
	public Optional<Claim> FindByStatus(@PathVariable("status") String status){
		return claimManagerI.FindBySubject(status);
	}
	
	
	
	@GetMapping("/calc")
	public Long Calcul(){
		return claimManagerI.CountClaims();
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
	public Claim modifyClaim(@RequestBody Claim C) {
	return claimManagerI.updateClaim(C);
	}
	
	
	
	@PutMapping("/decision")
	public ResponseEntity<?> modifyDecisionAndStatus(@RequestBody Claim C) {
		claimManagerI.updateClaimDecision(C);
		return new ResponseEntity<>("your decision has been update and the status has been set",HttpStatus.OK);
	}
	
	/*@GetMapping("/mail")
	public ResponseEntity<?> mail(){
		 claimManagerI.SendEmail();
		 return new ResponseEntity<>("your decision has been update and the status has been set",HttpStatus.OK);
	}*/
	
	
	
	/*@PutMapping("/updateStatus/{id}")
	public Claim updatestatus(@PathVariable("id") Long id) {
	return claimManagerI.updateStatus(id);
	}*/
	
	
	
	
	/*"idAdvertisment" : 45 ,
    "dateAdvertisment" : 444554,
	"enddate" : 55554677 ,
	"finalviews": null,
	"targetviews" : null ,
    "typeAdvertisement" : null ,
	"cost" : null ,
	"channel" : null*/
	
	
	
	
	
	
	/*"idClaim" :11 ,
    "decision" : "merci pour votre temps, votre livraison va etre verifiée" ,
    "date" : 12 ,
    "status" : null, 
    "description" : " medium product i'm so disappointed, also bad delivery   ",
    "subject" : SYSTEM,
    "level" : null,
    "systemProb" : SERVER ,
    "deliveryProb" : null ,
    "ProductProb": null,
    "user" : {
          "idUser" : 1,
"username_user" : null ,
"password_user" : null,
"phoneNumber_user" : null,
"emailAddress_user" : null,
"dateBirth_user" : null,
"address_user" : null,
"genderClient" : "FEMALE",
"workfieldClient" : null

    }
    */
	
	
	
	
	
	
}
