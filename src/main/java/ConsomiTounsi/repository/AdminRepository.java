package ConsomiTounsi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Role;
import ConsomiTounsi.entities.User;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Long>{
	List<Admin> findByRoleAdmin(Role role);
	
}