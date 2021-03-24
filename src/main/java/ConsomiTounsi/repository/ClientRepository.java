package ConsomiTounsi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ConsomiTounsi.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	
}
