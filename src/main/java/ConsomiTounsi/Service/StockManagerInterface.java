package ConsomiTounsi.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.Stock;

public interface StockManagerInterface {
	List<Stock> retrieveAllStock();
    Stock addStock(Stock S);
    void deleteStock(Long id);
    void deleteStock(String id);
    Stock updateStock(Stock O);
    Optional<Stock> FindStock(Long id);
    Optional<Stock> FindStock(String id);
    void verifyIfStockIsEmpty(Stock s);

    
    @Transactional
	void AddStock(String Stkname, Long quant, String productSt);
    @Transactional
	int UpdateStockQuantityByStockname(String Sn,float quantite);
    @Transactional
    List<Stock> FindStockByNameproduct(String namep);
    @Transactional
    int UpdateStockStatusByStockName(String stockname , boolean status_stock);
    @Transactional
    long getNbEmptyStock();

   

    
    
    /*
     	public MvtStock save(MvtStock entity);


	public List<MvtStock> selectAll();

	public List<MvtStock> selectAll(String sortField, String sort);


	public MvtStock getById(Long id);

	public MvtStock findOne(String paramName, Object paramValue);

	public MvtStock findOne(String[] paramNames, Object[] paramValues);

	public int findCountBy(String paramName, String paramValue); */
}
