package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Deliverer;

import ConsomiTounsi.entities.Delivery;

import java.util.List;
import java.util.Optional;

public interface DeliveryManagerInterface {
    List<Delivery> retrieveAllDelivery();
    Delivery addDelivery(Delivery de);
    void deleteDelivery(Long id);
    void deleteDelivery(String id);
    Optional<Delivery> FindDelivery(Long id);
    Optional<Delivery> FindDelivery(String id);
	Delivery updateDelivery(Delivery De);
	int CalculateScore(Delivery D);
}
