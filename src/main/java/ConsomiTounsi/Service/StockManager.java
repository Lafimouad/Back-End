package ConsomiTounsi.Service;

import java.math.BigDecimal;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.Stock;
import ConsomiTounsi.repository.ProductRepository;
import ConsomiTounsi.repository.StockRepository;

@Service
public class StockManager implements StockManagerInterface {
	
	

	@Autowired
	StockRepository Stor;
	
	@Autowired
	ProductRepository Pr;

	@Override
	public List<Stock> retrieveAllStock() {
		return (List<Stock>) Stor.findAll();	}

	@Override
	public Stock addStock(Stock S) {
		 return Stor.save(S);	}

	@Override
	public void deleteStock(Long id) {
		Stor.deleteById(id);		
	}

	@Override
	public void deleteStock(String id) {
    	Stor.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Stock updateStock(Stock O) {
        return Stor.save(O);

	}

	@Override
	public void AddStock(String Stkname, float quant, String productSt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Stock> FindStock(Long id) {
        return   Stor.findById(id);

	}

	@Override
	public int UpdateStockQuantityByStockname(String Sn, float quantite) {
		return Stor.UpdateStockQuantityByStockname(Sn, quantite);

	}

	@Override
	public Optional<Stock> FindStock(String id) {
		return  Stor.findById(Long.parseLong(id));
	}
	
	@Override
	public List<Stock> FindStockByNameproduct(String namep) {
		return Stor.FindStockByNameproduct(namep);
	}

	
	
	

	
	

}
