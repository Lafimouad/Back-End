package ConsomiTounsi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ConsomiTounsi.entities.Client;

@Transactional
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	
	@Query("SELECT COUNT(c) FROM Client c")
	long getNombreClient(); 
	
}
