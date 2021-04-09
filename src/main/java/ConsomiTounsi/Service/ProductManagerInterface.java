package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductManagerInterface {
    List<Product> retrieveAllProducts();
    Product addProduct(Product P);
    void deleteProduct(Long id);
    void deleteProduct(String id);
    Product updateProduct(Long id ,Product P);
    Optional<Product> FindProduct(Long id);
    Optional<Product> FindProduct(String id);}
