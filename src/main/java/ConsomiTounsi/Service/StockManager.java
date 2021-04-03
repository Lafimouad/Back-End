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
	ProductManager pm;

	@Autowired
	StockRepository Stor;

	@Override
	public int UpdateStockStatusByStockName(String stockname, boolean statusstock) {
		return Stor.UpdateStockStatusByStockName(stockname,statusstock);
	}

	@Override
	public List<Stock> retrieveAllStock() {
		return (List<Stock>) Stor.findAll();	}

	@Override
	public Stock addStock(Stock S) {
		  System.out.println(S.toString());
		        Stock optionalstock=Stor.save(S);
		        List<Product> products =S.getProduct();
		        for (int i=0;i<products.size();i++){

		            Product p=products.get(i);
		            p.setStock(optionalstock);
					pm.updateProduct(p);

				}

		        return optionalstock;
		    }


	@Override
	public long getNbEmptyStock() {
		return Stor.getNbEmptyStock();
	}

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

	/*@Override
	public void AddStock(String Stkname, Long quant, String productSt) {

	}*/

	@Override
	public Optional<Stock> FindStock(Long id) {
        return   Stor.findById(id);

	}

	@Override
	public long UpdateStockQuantityByStockname(String Sn, long quantite) {
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

	@Override
	public void verifyIfStockIsEmpty(Stock s) {
		 Long quantity = s.getProductQuantity();
		 if (quantity == 0)
		 {
		 	boolean status = s.isStatusStock();
		 	status = false;
		 	s.setStatusStock(status);
		}
	}
}
