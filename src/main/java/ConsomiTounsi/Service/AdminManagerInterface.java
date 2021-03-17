package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminManagerInterface {

    List<Admin> retrieveAllAdmin();
    Admin addAdmin(Admin A);
    void deleteAdmin(Long id);
    void deleteAdmin(String id);
    Admin updateAdmin(Admin A);
    Optional<Admin> FindAdmin(Long id);
    Optional<Admin> FindAdmin(String id);
}
