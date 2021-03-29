package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

public interface ProductManagerInterface {
    List<Product> retrieveAllProducts();
    Product addProduct(Product P);
    void deleteProduct(Long id);
    void deleteProduct(String id);
    Product updateProduct(Product P);
    Optional<Product> FindProduct(Long id);
    Optional<Product> FindProduct(String id);
   
    
    @Transactional
    List<Product> FindProductByIdStock(Long id);
    @Transactional
    List<Product> FindProductByIdShelf(Long id);
    
}
