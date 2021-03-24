package ConsomiTounsi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ConsomiTounsi.entities.Deliverer;

@Repository
public interface DelivererRepository extends CrudRepository<Deliverer, Long> {
}
