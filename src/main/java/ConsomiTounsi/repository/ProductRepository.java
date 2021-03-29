package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Product;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	@Query(value="select * from Product where stock_id_stock=?1",nativeQuery = true)
    List<Product> FindProductByIdStock(Long id);

    @Query(value="select * from Product where shelf_id_shelf=?1",nativeQuery = true)
    List<Product> FindProductByIdShelf(Long id);
	


}
