package ConsomiTounsi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ConsomiTounsi.entities.Deliverer;

@Transactional
@Repository
public interface DelivererRepository extends CrudRepository<Deliverer, Long> {
	
	
	@Query(value="SELECT d.deliverer.id_user FROM Deliverer d WHERE max(d.score_deliverer)" )
	Long getMaxScore();
	
	//@Query("SELECT COUNT(d) FROM Deliverer d")
	//long getNbDeliverer();
	
	//@Query("SELECT d FROM Deliverer d WHERE d.delivererOfTheMonthDeliverer = TRUE" )
	//Deliverer getDelivererOfTheMonth();

}
