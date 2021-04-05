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
    int addProductQuantity(long id);
    int decrementProductQuantity(long id);
    void resetQuantity();



        @Transactional
    long getNbProductsByshelf(long idshelf);
    
    @Transactional
    List<Product> FindProductByIdShelf(Long id);
    
}
