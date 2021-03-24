package ConsomiTounsi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ConsomiTounsi.entities.Deliverer;

@Repository
public interface DelivererRepository extends CrudRepository<Deliverer, Long> {
	
	
	@Query("SELECT COUNT(d) FROM Deliverer d WHERE d.availableDeliverer = TRUE" )
	long getNbAvailableDeliveres();
	
	@Query("SELECT COUNT(d) FROM Deliverer d")
	long getNbDeliverer();
	
	@Query("SELECT d FROM Deliverer d WHERE d.delivererOfTheMonthDeliverer = TRUE" )
	Deliverer getDelivererOfTheMonth();

}
