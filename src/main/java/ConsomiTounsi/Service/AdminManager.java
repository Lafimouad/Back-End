package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Role;
import ConsomiTounsi.entities.UserRole;
import ConsomiTounsi.repository.AdminRepository;
import ConsomiTounsi.configuration.config.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminManager implements AdminManagerInterface{
    
	@Autowired
    AdminRepository Ar;

    @Override

    public List<Admin>  retrieveAllAdmin() {
        return (List<Admin>) Ar.findAll();
    }

    @Override
    public void deleteAdminById(Long id) {
        Ar.deleteById(id);
    }

    @Override
    public void deleteAdminById(String id) {
        Ar.deleteById(Long.parseLong(id));
    }

    @Override
    public Admin updateAdmin(Admin A) {
        String encodedPassword = bCryptPasswordEncoder.encode(A.getPasswordUser());
        A.setPasswordUser(encodedPassword);
        return Ar.save(A);}

    @Override
    public Admin FindAdminById(Long id) {
        return  Ar.findById(id).orElse(new Admin());
    }

    @Override
    public Admin FindAdminById(String id) {
        return  Ar.findById(Long.parseLong(id)).orElse(new Admin());
    }
    
    public List<Admin> FindAdminByRole(Role role){
    	return Ar.findByRoleAdmin(role);
    }

	@Override
	public long getNbAdminByRole(Role role) {
		return Ar.getNbAdminByRole(role);
	}

	@Override
	public long getNbAdmin() {
		return Ar.getNbAdmin();
	}

	//registration

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminManager(AdminRepository ar, BCryptPasswordEncoder bCryptPasswordEncoder) {
        Ar = ar;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Autowired
    EmailValidator emailValidator;

    @Override
    public Admin SignUpAdmin(Admin user){
        boolean isValidEmail = emailValidator.test(user.getEmailAddressUser());
        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPasswordUser());
        user.setPasswordUser(encodedPassword);
        user.setRoleUser(UserRole.ADMIN);
        return Ar.save(user);
    }

}
