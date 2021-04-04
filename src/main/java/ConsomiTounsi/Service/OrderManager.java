package ConsomiTounsi.Service;


import ConsomiTounsi.controllers.mouadh_Controllers.MessageResponseModel;
import ConsomiTounsi.entities.Order;
import ConsomiTounsi.entities.Product;
import ConsomiTounsi.repository.OrderRepository;
import ConsomiTounsi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderManager implements OrderManagerInterface{
    @Autowired
    OrderRepository or;
    @Autowired
    ProductRepository pr;
    @Autowired
    ProductManager pm;
    @Override
    public List<Order> retrieveAllOrder() {
        return (List<Order>) or.findAll();
    }

    @Override
    public Order addOrder(Order O) {
        System.out.println(O.toString());
        Order optionalorder=or.save(O);
       /* List<Product> products =O.getProducts();
        for (int i=0;i<products.size();i++){

            Product p=products.get(i);
            p.setOrder(optionalorder);
            pm.updateProduct(p);
        }
        
        */
        return optionalorder;
    }

    @Override
    public void deleteOrder(Long id) {
       Optional<Order> optionalOrder=or.findById(id);
       if (!optionalOrder.isPresent()){
           throw new IllegalStateException("Order Not Found");
       }
        or.deleteById(id);
    }
    // Update An Order with some Control
    @Override
    public Order updateOrder(Long id ,Order O) {
        Optional<Order> optionalOrder=or.findById(id);
        if (!optionalOrder.isPresent()){
            throw new IllegalStateException("Id Not Found");
        }
        Order orderLegacy = optionalOrder.get();
        if (O.getCost()!= 0||O.getCost()!=(orderLegacy.getCost())){
            orderLegacy.setCost(O.getCost());}
        if (O.getDate()!=null ||!O.getDate().equals(orderLegacy.getDate())){
            orderLegacy.setDate(O.getDate());}
        if (O.getPaymentType()!=null||!O.getPaymentType().equals(orderLegacy.getPaymentType())){
            orderLegacy.setPaymentType(O.getPaymentType());}
        if (O.getWeight()!=0||O.getWeight()!=orderLegacy.getWeight()){
            orderLegacy.setWeight(O.getWeight());}

        if (O.getProducts()!=null){
            orderLegacy.addproducts(O.getProducts());
        }
        /*
        List<Product> products =orderLegacy.getProducts();
        for (int i=0;i<products.size();i++){

            Product p=products.get(i);
            pm.updateProduct(p);
        }

         */

        return or.save(orderLegacy);
    }
    // Find Order By Id
    @Override
    public Optional<Order> FindOrder(Long id) {

        return   or.findById(id);
    }

    //Add Products to Order

    public ResponseEntity<?> addProductsToOrder (Long id , List<Product> productList){
        for ( Product product : productList ){
            Optional<Product > optionalProduct  = pr.findById(product.getId());
            if ( ! optionalProduct.isPresent()){
                return  new ResponseEntity<>( new MessageResponseModel( " The Product with Id  "+ product.getId()
                        +"Does not exist "), HttpStatus.BAD_REQUEST );

            }

            Optional<Order> optionalOrder = or.findById(id);

            if ( !optionalOrder.isPresent()){
                return  new ResponseEntity<>( new MessageResponseModel("hotel id not Found "),HttpStatus.BAD_REQUEST) ;

            }

            Order order =  optionalOrder.get();

            order.addproducts(product);

        }
        return  new ResponseEntity<>( HttpStatus.OK);}

}
