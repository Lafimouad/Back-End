package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Role;
import ConsomiTounsi.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Admin addAdmin(Admin A) {
        return Ar.save(A);
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
        return Ar.save(A) ;   }

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
}
