package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Advertisement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends CrudRepository<Advertisement,Long> {
}
