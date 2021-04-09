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
        if (!P.getCode().startsWith("619")){
            throw new IllegalStateException("This Product isn't Tunisian");
        }
        return Pr.save(P);
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> optionalProduct=Pr.findById(id);
        if (!optionalProduct.isPresent()) {
            throw new IllegalStateException("Product Not Found");
        }
        Pr.deleteById(id);

    }

    @Override
    public void deleteProduct(String id) {


        Pr.deleteById(Long.parseLong(id));
    }

    @Override
    public Product updateProduct(Long id,Product P) {
        Optional<Product> optionalProduct=Pr.findById(id);
        if (!optionalProduct.isPresent()){
            throw new IllegalStateException("Product id Not Found");
        }
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
    public boolean product_exist(Long id)
    {
        Optional<Product> p=this.Pr.findById(id);
        return  p.isPresent();
    }



    //find By Name
    public List<Product> findByName(String name){
        return Pr.findProductByName(name);
    }
    // find By Rating
    public List<Product> findByRating(){
        return Pr.findAllByOrderByRatingDesc();
    }
    // find All Product by desc Order
    public List<Product> findByDescPrice(){
        return Pr.findAllByOrderByPriceDesc();
    }
    // find All Product By Asc Order
    public List<Product> findByAscPrice(){
        return Pr.findAllByOrderByPriceAsc();
    }
    //find Product By Category
    public List<Product> findProductByCategory(String name){
        return  Pr.findProductByCategory(name);
    }

    /*
    public List<Product> FindByOrder(Long id) {
    return this.Pr.FindByOrder(id);
    } */
}
