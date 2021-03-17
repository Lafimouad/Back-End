package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<Store,Long> {
}
