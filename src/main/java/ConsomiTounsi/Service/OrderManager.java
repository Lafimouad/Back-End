package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Order;
import ConsomiTounsi.entities.Product;
import ConsomiTounsi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderManager implements OrderManagerInterface{
    @Autowired
    ProductManager pm;
    @Autowired
    OrderRepository or;
    @Override
    public List<Order> retrieveAllOrder() {
        return (List<Order>) or.findAll();
    }

    @Override
    public Order addOrder(Order O) {
        System.out.println(O.toString());
        Order optionalorder=or.save(O);
        List<Product> products =O.getProducts();
        for (int i=0;i<products.size();i++){

            Product p=products.get(i);
            p.setOrder(optionalorder);
            pm.updateProduct(p);
        }




        return optionalorder;
    }

    @Override
    public void deleteOrder(Long id) {
       or.deleteById(id);
    }

    @Override
    public void deleteOrder(String id) {
        or.deleteById(Long.parseLong(id));
    }

    @Override
    public Order updateOrder(Order O) {
        return or.save(O);
    }

    @Override
    public Optional<Order> FindOrder(Long id) {
        return   or.findById(id);
    }

    @Override
    public Optional<Order> FindOrder(String id) {
        return  or.findById(Long.parseLong(id));
    }
}
