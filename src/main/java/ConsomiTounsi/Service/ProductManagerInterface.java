package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.TypeCategory;
import ConsomiTounsi.entities.TypeCriteria;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

public interface ProductManagerInterface {
    List<Product> retrieveAllProducts();
    Product addProduct(Product P);
    void deleteProduct(Long id);
    void deleteProduct(String id);
    Product updateProduct(Product P);
    Optional<Product> FindProduct(Long id);
    Optional<Product> FindProduct(String id);
   // List<Product>findByCategoryProduct(TypeCategory cp);
   // void showAdvertsement( List<Product> products,TypeCriteria criteria) ;
    EntityManager getEntityManager();	
}
