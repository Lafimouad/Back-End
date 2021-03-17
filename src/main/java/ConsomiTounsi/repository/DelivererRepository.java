package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Deliverer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelivererRepository extends CrudRepository<Deliverer,Long> {
}
