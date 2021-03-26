package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Client;
import ConsomiTounsi.entities.UserRole;
import ConsomiTounsi.repository.ClientRepository;

import java.util.List;

import ConsomiTounsi.configuration.config.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientManager implements ClientManagerInterface{

	@Autowired
	ClientRepository cr;
	
	@Override
	public List<Client> retrieveAllClient() {
        return (List<Client>) cr.findAll();

	}

	@Override
	public void deleteClientById(Long id) {
        cr.deleteById(id);
	}

	@Override
	public void deleteClientById(String id) {
        cr.deleteById(Long.parseLong(id));		
	}

	@Override
	public Client updateClient(Client Cl) {
		String encodedPassword = bCryptPasswordEncoder.encode(Cl.getPasswordUser());
		Cl.setPasswordUser(encodedPassword);
		return cr.save(Cl);
	}

	@Override
	public Client FindClientById(Long id) {
		return  cr.findById(id).orElse(new Client());
	}

	@Override
	public Client FindClientById(String id) {
		return  cr.findById(Long.parseLong(id)).orElse(new Client());
	}

	@Override
	public long getNombreClient() {
		return cr.getNombreClient();
	}

	//registration

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public ClientManager(ClientRepository cr, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.cr = cr;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Autowired
	EmailValidator emailValidator;

	@Override
	public Client SignUpClient(Client user) {
		boolean isValidEmail = emailValidator.test(user.getEmailAddressUser());
		if (!isValidEmail) {
			throw new IllegalStateException("Email not valid");
		}
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPasswordUser());
		user.setPasswordUser(encodedPassword);
		user.setRoleUser(UserRole.CLIENT);
		return cr.save(user);
	}

}
