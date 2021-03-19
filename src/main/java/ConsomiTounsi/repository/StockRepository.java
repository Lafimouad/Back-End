package ConsomiTounsi.repository;

import org.springframework.data.repository.CrudRepository;

import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Stock;

public interface StockRepository extends CrudRepository<Stock ,Long> {

}
