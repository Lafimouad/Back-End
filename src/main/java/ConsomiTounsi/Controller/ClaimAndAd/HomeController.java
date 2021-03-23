package ConsomiTounsi.Controller.ClaimAndAd;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homeTest")
public class HomeController {

	    @GetMapping
	    ResponseEntity<?> helloApp(){
	        return new ResponseEntity<>(new Test ("trying to test"), HttpStatus.OK);
	    }
	}
