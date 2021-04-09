package ConsomiTounsi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ConsomiTounsi.entities.Deliverer;

@Transactional
@Repository
public interface DelivererRepository extends CrudRepository<Deliverer, Long> {
	
	/*@Query("select de FROM deliverer WHERE de.availableDeliverer=TRUE")
	List<Deliverer> findAvailableDeliverers();
	@Query("select de FROM deliverer WHERE de.usernameUser=:name")
	List<Deliverer> findDelivererByNameParams(@Param("name") String name);*/

}
