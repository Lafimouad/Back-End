package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Delivery;

import java.util.List;
import java.util.Optional;

public interface DeliveryManagerInterface {
    List<Delivery> retrieveAllDelivery();
    Delivery addDelivery(Delivery De);
    void deleteDelivery(Long id);
    void deleteDelivery(String id);
    Delivery updateDeliverer(Delivery De);
    Optional<Delivery> FindDelivery(Long id);
    Optional<Delivery> FindDelivery(String id);
}
