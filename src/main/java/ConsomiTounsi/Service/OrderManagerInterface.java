package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Order;

import java.util.List;
import java.util.Optional;

public interface OrderManagerInterface {
    List<Order> retrieveAllOrder();
    Order addOrder(Order O);
    void deleteOrder(Long id);
    void deleteOrder(String id);
    Order updateOrder(Order O);
    Optional<Order> FindOrder(Long id);
    Optional<Order> FindOrder(String id);
}
