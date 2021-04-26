package ConsomiTounsi.Service;

import java.util.List;
import java.util.Optional;

import ConsomiTounsi.entities.Order;
import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.Stock;
import ConsomiTounsi.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StockManager implements StockManagerInterface {
	@Autowired
	StockRepository Sr;
	@Autowired
	ProductManager sm;
	@Override
	public List<Stock> retrieveAllStock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock addStock(Stock S) {
		System.out.println(S.toString());
		Stock optionalStock=Sr.save(S);
		List<Product> products=S.getProducts();
		for (int i=0;i<products.size();i++){

			Product p=products.get(i);
			p.setStock(optionalStock);
			sm.updateProduct(p.getId(),p);
		}
		return optionalStock;
	}

	@Override
	public void deleteStock(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStock(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Stock updateStock(Stock O) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Stock> FindStock(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Stock> FindStock(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
