package ConsomiTounsi.repository;

import java.util.Date;
import java.util.List;

import ConsomiTounsi.entities.Role;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.Stock;

@Repository
@Transactional
public interface StockRepository extends CrudRepository<Stock ,Long> {
	
	/*@Modifying
	@Query(value="INSERT INTO Stock (stockName,productQuantity) VALUES (:Stkname , :quant ", nativeQuery= true)
	void AddStock(@Param("Stkname") String Stkname,@Param("quant") float quant);*/
	
	@Modifying
	@Query("UPDATE Stock s SET s.productQuantity=:quantite WHERE s.stockName=:Sn")
	long UpdateStockQuantityByStockname(@Param("Sn") String Sn,@Param("quantite") long quantite);
	
	@Query(value="select * from Stock where name_product=?1",nativeQuery = true)
    List<Stock> FindStockByNameproduct(String namep);

	@Modifying
	@Query("UPDATE Stock s SET s.statusStock =: Optional[statusstock] WHERE s.stockName=:stockname")
	int UpdateStockStatusByStockName(@Param("stockname") String stockname,@Param("statusstock") boolean statusstock);

	@Query("SELECT COUNT(s) FROM Stock s WHERE s.statusStock = FALSE" )
	long getNbEmptyStock();
    
}
