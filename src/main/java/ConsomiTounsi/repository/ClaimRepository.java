package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Claim;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends CrudRepository<Claim,Long> {
}