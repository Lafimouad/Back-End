package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.TypeCategory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	
	@Query("SELECT p FROM Product p WHERE p.categoryProduct like 'makeUp%' or p.categoryProduct like 'Stationery%' " )
	List<Product> findByCategoryProduct( TypeCategory cp);
	
	
	@Query("SELECT p FROM Product p WHERE p.categoryProduct like 'ShavingTools%' or p.categoryProduct like 'Stationery%' " )
	List<Product> findByCategoryProduct2( TypeCategory cp);
	
	@Query("SELECT p FROM Product p WHERE p.categoryProduct like 'Tools%' " )
	List<Product> findByCategoryProduct3( TypeCategory cp);
	
	@Query("SELECT p FROM Product p WHERE p.categoryProduct like 'makeUp%' " )
	List<Product> findByCategoryProduct4( TypeCategory cp);
	
	@Query("SELECT p FROM Product p WHERE p.categoryProduct like 'Cosmetics%' or  p.categoryProduct like 'ShavingTools%' " )
	List<Product> findByCategoryProduct5( TypeCategory cp);
}


