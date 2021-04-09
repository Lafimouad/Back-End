package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Deliverer;
import ConsomiTounsi.entities.Delivery;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery,Long> {
	
	/*@Query("select d.scoreDelivery FROM delivery")
	List<Delivery> DeliveryScores();
	
    @Modifying 
    @Query("update Delivery d set d.accomplished=FALSE")
    int updateDeliveryAccomplishment();*/
	
}
