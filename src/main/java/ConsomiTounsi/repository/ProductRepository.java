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


    @Query(value="select * from Product where shelf_id_shelf=?1",nativeQuery = true)
    List<Product> FindProductByIdShelf(long id);

    @Query("SELECT COUNT(p) FROM Product p WHERE p.shelf_id_shelf = idshelf" )
    long getNbProductsByshelf(long idshelf);
	


}
