package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Product;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {


    @Query(value="select * from Product where shelf_id_shelf=?1",nativeQuery = true)
    List<Product> FindProductByIdShelf(long id);

    @Query(value="SELECT COUNT(p) FROM Product p WHERE p.shelf_id_shelf = idshelf",nativeQuery = true)
    int getNbProductsByshelf(long idshelf);

    @Modifying
    @Query (value="UPDATE Product p SET p.quantityProduct=:qn WHERE p.id_product=:id",nativeQuery = true)
    int AddQuantity(@Param("qn") long qn, @Param("id") long id);

    @Modifying
    @Query(value="UPDATE Product P SET P.quantityProduct=0" ,nativeQuery= true )
    int resetQuantity();
	


}
