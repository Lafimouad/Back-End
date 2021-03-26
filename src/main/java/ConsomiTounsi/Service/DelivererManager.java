package ConsomiTounsi.Service;

import java.util.List;


import ConsomiTounsi.configuration.config.EmailValidator;
import ConsomiTounsi.entities.Client;
import ConsomiTounsi.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ConsomiTounsi.entities.Deliverer;
import ConsomiTounsi.repository.DelivererRepository;

@Service
public class DelivererManager implements DelivererManagerInterface{

	@Autowired
	DelivererRepository dr;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public DelivererManager(DelivererRepository dr, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.dr = dr;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public List<Deliverer> retrieveAllDeliverer() {
        return (List<Deliverer>) dr.findAll();
	}

	@Autowired
	EmailValidator emailValidator;

	@Override
	public Deliverer addDeliverer(Deliverer D) {
		boolean isValidEmail = emailValidator.test(D.getEmailAddressUser());
			if (!isValidEmail) {
				throw new IllegalStateException("Email not valid");
			}
		String encodedPassword = bCryptPasswordEncoder.encode(D.getPasswordUser());
		D.setPasswordUser(encodedPassword);
		D.setRoleUser(UserRole.DELIVERER);
		return dr.save(D);
	}

	@Override
	public void deleteDelivererById(Long id) {
        dr.deleteById(id);
		
	}

	@Override
	public void deleteDelivererById(String id) {
		dr.deleteById(Long.parseLong(id));		
	}

	@Override
	public Deliverer updateDeliverer(Deliverer D) {
		String encodedPassword = bCryptPasswordEncoder.encode(D.getPasswordUser());
		D.setPasswordUser(encodedPassword);
		return dr.save(D);
	}

	@Override
	public Deliverer FindDelivererById(Long id) {
		return  dr.findById(id).orElse(new Deliverer());
	}

	@Override
	public Deliverer FindDelivererById(String id) {
		return  dr.findById(Long.parseLong(id)).orElse(new Deliverer());
	}

	@Override
	public long getNbAvailableDeliveres() {
		return dr.getNbAvailableDeliveres();
	}

	@Override
	public long getNbDeliverer() {
		return dr.getNbDeliverer();
	}

	@Override
	public Deliverer getDelivererOfTheMonth() {
		return dr.getDelivererOfTheMonth();
	}

}
