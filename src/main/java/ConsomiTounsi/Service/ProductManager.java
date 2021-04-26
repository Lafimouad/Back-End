package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Claim;
import ConsomiTounsi.entities.Feedback;
import ConsomiTounsi.entities.Product;
import ConsomiTounsi.repository.FeedbackRepository;
import ConsomiTounsi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
    public class ProductManager implements ProductManagerInterface {
    @Autowired
    ProductRepository Pr;
    @Autowired
    ClaimManager claimManager;

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
        Optional<Product> optionalProduct = Pr.findById(id);
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
    public Product updateProduct(Long id, Product P) {
        Optional<Product> optionalProduct = Pr.findById(id);
        if (!optionalProduct.isPresent()) {
            throw new IllegalStateException("Product id Not Found");
        }
        return Pr.save(P);
    }

    @Override
    public Optional<Product> FindProduct(Long id) {
        return Pr.findById(id);
    }

    @Override
    public Optional<Product> FindProduct(String id) {
        return Pr.findById(Long.parseLong(id));
    }

    public boolean product_exist(Long id) {
        Optional<Product> p = this.Pr.findById(id);
        return p.isPresent();
    }


    //find By Name
    public List<Product> findByName(String name) {
        return Pr.findProductByName(name);
    }

    // find By Rating
    public List<Product> findByRating() {
        return Pr.findAllByOrderByRatingDesc();
    }

    // find All Product by desc Order
    public List<Product> findByDescPrice() {
        return Pr.findAllByOrderByPriceDesc();
    }

    // find All Product By Asc Order
    public List<Product> findByAscPrice() {
        return Pr.findAllByOrderByPriceAsc();
    }

    //find Product By Category
    public List<Product> findProductByCategory(String name) {
        return Pr.findProductByCategory(name);
    }

    /*
    public List<Product> FindByOrder(Long id) {
    return this.Pr.FindByOrder(id);
    } */

    // Service that send Auto Claim if the the Rating is less than 2.0

    public void sendAutoReclamation(List<Product> productList) {

        for (Product product : productList) {
            Product optionalProduct = Pr.findById(product.getId()).get();
            Feedback feedback = optionalProduct.getFeedback();
            float nb = feedback.getNote();
                if (nb <= 2) {

                    Claim claim = new Claim();
                    claim.setDecision("Not Yet");
                    claim.setDescription("my mood is moody");
                    claim.setLevel(99);
                    this.claimManager.addClaim(claim);



            }
        }
    }

   // send List of id for her majesty the Nooba maha hail to the king Mouadh
   public List<Long> sendIdClaimedProduct(){
       List<Long> lass3ed=new ArrayList<Long>();
       for ( Product product : Pr.findAll() ){
           Feedback feedback= product.getFeedback() ;
           float nb=feedback.getNote();
           if (nb<=2){
               Long id= product.getId() ;
               lass3ed.add(id);
           }

       }

       return lass3ed;
   }
   // make Worst Product unavailable

    public void makeUnavailible(){
        List<Long> list=claimManager.WorstProducts();
        for (Long id: list){
            Optional<Product> optionalProduct=Pr.findById(id);
            if (optionalProduct.isPresent()){
                Product product=optionalProduct.get();
                product.setAvailable(false);
                Pr.save(product);

            }

        }

    }
    @Autowired
    FeedbackRepository feedbackRepository;

    // make product of the months
    public void makeProductOfTheMonth(){
        List<Feedback>list=feedbackRepository.findTop10ByNote(4);
        for (Feedback feedback:list){
            Product product =feedback.getProduct();
            product.setProductofthemonth(true);
        }

    }




}
