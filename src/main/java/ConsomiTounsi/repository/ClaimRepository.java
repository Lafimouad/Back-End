package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Claim;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface ClaimRepository extends CrudRepository<Claim,Long> {

	
	@Query("SELECT m FROM Claim m WHERE m.subject=:subject")
    Optional<Claim> findBysubject(@Param("subject") String subject);
	
	Optional<Claim> findByDate(Date date);
	
	
	
	
}
