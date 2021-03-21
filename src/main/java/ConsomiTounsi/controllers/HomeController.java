package ConsomiTounsi.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")

public class HomeController {
    @GetMapping
    ResponseEntity<?> helloApp(){
        return new ResponseEntity<>(new TestResponseModel("Ab3ath quran ye Walid"), HttpStatus.OK);
    }
}
