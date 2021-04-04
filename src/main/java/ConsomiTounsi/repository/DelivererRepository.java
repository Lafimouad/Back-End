package ConsomiTounsi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ConsomiTounsi.entities.Deliverer;

@Transactional
@Repository
public interface DelivererRepository extends CrudRepository<Deliverer, Long> {
	
	
	@Query("SELECT COUNT(d) FROM Deliverer d WHERE d.availableDeliverer = TRUE" )
	long getNbAvailableDeliveres();
	
	@Query("SELECT COUNT(d) FROM Deliverer d")
	long getNbDeliverer();
	
	@Query("SELECT d FROM Deliverer d WHERE d.delivererOfTheMonthDeliverer = TRUE" )
	Deliverer getDelivererOfTheMonth();

	@Query("SELECT SUM(d.salary) FROM Deliverer d" )
	double SommeSaliareDeliverer();

	@Modifying
	@Query(value="UPDATE deliverer d SET d.salary=:nb WHERE d.id_user=:id",nativeQuery= true)
	int salaireAvecPrime(@Param("nb") double nb , @Param("id") long id);

	@Modifying
	@Query(value="UPDATE deliverer d SET d.bonus_deliverer=:nb WHERE d.id_user=:id",nativeQuery= true)
	int UpdatePrimeDeliverer(@Param("nb") double nb , @Param("id") long id);

	@Modifying
	@Query(value="UPDATE deliverer d SET d.deliverer_of_the_month_delivererr = TRUE WHERE d.id_user=:id",nativeQuery= true)
	int updateDelivofthemonth(@Param("id") long id);

	@Modifying
	@Query(value="UPDATE deliverer d SET d.bonus_deliverer=0" ,nativeQuery= true )
	int resetBonus();
}
