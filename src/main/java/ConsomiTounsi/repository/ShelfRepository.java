package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Shelf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepository extends CrudRepository<Shelf,Long> {
}
