package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminManager implements AdminManagerInterface{
    @Autowired
    AdminRepository Ar;

    @Override

    public List<Admin> retrieveAllAdmin() {
        return (List<Admin>) Ar.findAll();
    }

    @Override
    public Admin addAdmin(Admin A) {
        return Ar.save(A);
    }

    @Override
    public void deleteAdmin(Long id) {
        Ar.deleteById(id);
    }

    @Override
    public void deleteAdmin(String id) {
        Ar.deleteById(Long.parseLong(id));
    }

    @Override
    public Admin updateAdmin(Admin A) {
        return Ar.save(A) ;   }

    @Override
    public Optional<Admin> FindAdmin(Long id) {
        return   Ar.findById(id);
    }

    @Override
    public Optional<Admin> FindAdmin(String id) {
        return  Ar.findById(Long.parseLong(id));
    }
}
