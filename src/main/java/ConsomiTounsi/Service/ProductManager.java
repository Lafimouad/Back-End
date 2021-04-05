package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Product;
import ConsomiTounsi.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
    public class ProductManager implements ProductManagerInterface{

	

	@Autowired
    ProductRepository Pr;

	
    @Override
    public List<Product> retrieveAllProducts() {
        return (List<Product>) Pr.findAll();
    }

    @Override
    public Product addProduct(Product P) { 
        return Pr.save(P);

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
    public List<Product> FindProductByIdShelf(Long id) {
        return this.Pr.FindProductByIdShelf(id);
    }

   /* @Override
   	public List<Product> FindProductByIdStock(Long id) {
   		return this.Pr.FindProductByIdStock(id);
   	}*/

    @Override
    public long getNbProductsByshelf(long idshelf) {
        return Pr.getNbProductsByshelf(idshelf);   }

    @Override
    public int addProductQuantity(long id) {
        Product p = Pr.findById(id).orElse(new Product());
        int nb = p.getQuantityProduct() + 1;
        return Pr.AddAbsence(nb , id);
    }
        
}
