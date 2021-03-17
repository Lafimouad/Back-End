package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Order;
import ConsomiTounsi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderManager implements OrderManagerInterface{
    @Autowired
    OrderRepository Or;
    @Override
    public List<Order> retrieveAllOrder() {
        return null;
    }

    @Override
    public Order addOrder(Order O) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }

    @Override
    public void deleteOrder(String id) {

    }

    @Override
    public Order updateOrder(Order O) {
        return null;
    }

    @Override
    public Optional<Order> FindOrder(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Order> FindOrder(String id) {
        return Optional.empty();
    }
}
