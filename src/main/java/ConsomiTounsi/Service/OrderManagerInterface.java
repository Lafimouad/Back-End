package ConsomiTounsi.Service;
import java.util.Optional;
import java.util.List;


import ConsomiTounsi.entities.Order;

public interface OrderManagerInterface {
    List<Order> retrieveAllOrder();
    Order addOrder(Order O);
    void deleteOrder(Long id);
    void deleteOrder(String id);
    Order updateOrder(Order O);
    Optional<Order> FindOrder(Long id);
    Optional<Order> FindOrder(String id);
}
