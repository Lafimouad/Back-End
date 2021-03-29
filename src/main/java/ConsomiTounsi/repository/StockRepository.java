package ConsomiTounsi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.Stock;

@Transactional
public interface StockRepository extends CrudRepository<Stock ,Long> {
	
	@Modifying
	@Query(value="INSERT INTO Stock (Stockname,quantite,productStock) VALUES (:Stkname , :quant , :productSt)", nativeQuery= true)
	void AddUser(@Param("Stkname") String Stkname,@Param("quant") float quant,@Param("productSt") String productSt);
	
	@Modifying
	@Query("UPDATE Stock s SET u.quantite=:quantite WHERE s.Stockname=:Sn")
	int UpdateStockQuantityByStockname(@Param("Sn") String Sn,@Param("quantite") float quantite);
	
	@Query(value="select * from Stock where nameProduct=?1",nativeQuery = true)
    List<Stock> FindStockByNameproduct(String namep);

	@Modifying
	@Query("UPDATE Stock s SET u.status_stock=:status_stock WHERE s.Stockname=:stockname")
	int UpdateStockStatusByStockName(@Param("stockname") String stockname,@Param("status_stock") boolean status_stock);
	
    
}
