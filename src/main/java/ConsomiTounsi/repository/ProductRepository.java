package ConsomiTounsi.repository;

import ConsomiTounsi.entities.Product;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    /*
    @Query(value="select * from product where order_id_order=?1",nativeQuery = true)
    List<Product> FindByOrder(Long id);

     */

    List<Product> findProductByName(String name);
    List<Product> findAllByOrderByRatingDesc();
    List<Product> findAllByOrderByPriceDesc();
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findProductByCategory(String category);
    Optional<Product> findTopByOrderByIdDesc() ;
 /*   @Query("select id from product order by id desc  limit 1 \n")
    Optional<Product> findLastItemAdde () ;*/
}
