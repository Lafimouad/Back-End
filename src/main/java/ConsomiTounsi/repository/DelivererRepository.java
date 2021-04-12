package ConsomiTounsi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ConsomiTounsi.entities.Deliverer;


@Repository
public interface DelivererRepository extends CrudRepository<Deliverer, Long> {
	
	
	@Query(value="SELECT id_user FROM deliverer WHERE score_deliverer= (SELECT MAX(score_deliverer) FROM deliverer)",nativeQuery = true)
        	long getMaxScore();
	
	//@Query("SELECT COUNT(d) FROM Deliverer d")
	//long getNbDeliverer();
	
	//@Query("SELECT d FROM Deliverer d WHERE d.delivererOfTheMonthDeliverer = TRUE" )
	//Deliverer getDelivererOfTheMonth();

}
