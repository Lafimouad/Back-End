package ConsomiTounsi.Controller.ClaimAndAd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ConsomiTounsi.Service.ClaimManager;
import ConsomiTounsi.entities.Claim;

@RestController
@RequestMapping("/Claim")
public class ClaimController {
	
	@Autowired
	ClaimManager claimManager ;
	
	
	
	@GetMapping("FindClaim/{id}")
	public Optional<Claim> FindClaim(Long id){
		return claimManager.FindClaim(id);
	
	}
	
	@PostMapping
	ResponseEntity<?> addClaim(@RequestBody Claim C){

		claimManager.addClaim(C);
	        return new ResponseEntity<>("Claim ajouté",HttpStatus.CREATED);
	}
}
