package ConsomiTounsi.controllers;

import ConsomiTounsi.Service.AdminManagerInterface;
import ConsomiTounsi.Service.ClientManagerInterface;
import ConsomiTounsi.Service.UserManagerInterface;
import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Client;
import ConsomiTounsi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class HomeController {

	@Autowired
	ClientManagerInterface cs;

	@Autowired
	AdminManagerInterface as;

	@Autowired
	UserManagerInterface us;

	@PostMapping("register/manager")
	public User register(@RequestBody User user) {return us.SingUpManager(user);}

	@PostMapping("register/client")
	public Client register(@RequestBody Client user) {
		return cs.SignUpClient(user);
	}

	@PostMapping("register/admin")
	public Admin register(@RequestBody Admin user){
		return as.SignUpAdmin(user);
	}

	@GetMapping("/")
	public String Home(){
		return ("<h1> Welcome </h1>");
	}

	@GetMapping("/admin")
	public String admin(){
		return ("<h1> Welcome Admin </h1>");
	}

	@GetMapping("/client")
	public String client(){
		return ("<h1> Welcome Client </h1>");
	}

	@GetMapping("/manager")
	public String Manager(){
		return ("<h1> Welcome Manager </h1>");
	}

}
