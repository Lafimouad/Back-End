package ConsomiTounsi.Service;

import java.util.List;
import java.util.Optional;

import ConsomiTounsi.entities.Stock;

public interface StockManagerInterface {
	List<Stock> retrieveAllStock();
    Stock addStock(Stock S);
    void deleteStock(Long id);
    void deleteStock(String id);
    Stock updateStock(Stock O);
    Optional<Stock> FindStock(Long id);
    Optional<Stock> FindStock(String id);
}
