package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Role;

import java.util.List;

public interface AdminManagerInterface {

    List<Admin> retrieveAllAdmin();
    Admin addAdmin(Admin A);
    void deleteAdminById(Long id);
    void deleteAdminById(String id);
    Admin updateAdmin(Admin A);
    Admin FindAdminById(Long id);
    Admin FindAdminById(String id);
    List<Admin> FindAdminByRole(Role role);
}
