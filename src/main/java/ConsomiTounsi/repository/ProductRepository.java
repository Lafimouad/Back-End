package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Product;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	@Query(value="select * from stock where stock_id_stock=?1",nativeQuery = true)
    List<Product> FindByStock(Long id);




}
