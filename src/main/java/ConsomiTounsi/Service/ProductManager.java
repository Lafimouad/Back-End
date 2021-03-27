package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.Stock;
import ConsomiTounsi.repository.ProductRepository;
import ConsomiTounsi.repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class ProductManager implements ProductManagerInterface{
   

	

	@Autowired
    ProductRepository Pr;
	
	@Autowired
    StockRepository S;
	
    @Override
    public List<Product> retrieveAllProducts() {
        return (List<Product>) Pr.findAll();
    }

    @Override
    public Product addProduct(Product P) { 
    	Stock s = 
    	float quan= s.getProduct_quantity();
        Product  optionalproduct = Pr.save(P);
        
        return optionalproduct;
        
        
    }

    @Override
    public void deleteProduct(Long id) {
        Pr.deleteById(id);

    }

    @Override
    public void deleteProduct(String id) {
        Pr.deleteById(Long.parseLong(id));
    }

    @Override
    public Product updateProduct(Product P) {
        return Pr.save(P);
    }

    @Override
    public Optional<Product> FindProduct(Long id) {
      return   Pr.findById(id);
    }

    @Override
    public Optional<Product> FindProduct(String id) {
      return  Pr.findById(Long.parseLong(id));
    }
    
    @Override
   	public List<Product> FindByStock(Long id) {
   		return this.Pr.FindByStock(id);
   	}

	
    


}
