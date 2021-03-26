package ConsomiTounsi.controllers;

import ConsomiTounsi.Service.AdminManagerInterface;
import ConsomiTounsi.Service.ClientManagerInterface;
import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	ClientManagerInterface cs;

	@Autowired
	AdminManagerInterface as;

	@PostMapping("register/Client")
	public Client register(@RequestBody Client user){
		return cs.SignUpClient(user);
	}
	@PostMapping("register/Admin")
	public Admin register(@RequestBody Admin user){
		return as.SignUpAdmin(user);
	}
}
