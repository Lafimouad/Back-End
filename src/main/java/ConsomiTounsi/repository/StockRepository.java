package ConsomiTounsi.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Stock;

public interface StockRepository extends CrudRepository<Stock ,Long> {
	
	@Modifying
	@Query(value="INSERT INTO Stock (Stockname,quantite,productStock) VALUES (:Stkname , :quant , :productSt)", nativeQuery= true)
	void AddUser(@Param("Stkname") String Stkname,@Param("quant") float quant,@Param("productSt") String productSt);

}
