package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Deliverer;

import java.util.List;
import java.util.Optional;

public interface DelivererManagerInterface {
    List<Deliverer> retrieveAllDeliverer();
    Deliverer addDeliverer(Deliverer D);
    void deleteDeliverer(Long id);
    void deleteDeliverer(String id);
    Deliverer updateDeliverer(Deliverer D);
    Optional<Deliverer> FindDeliverer(Long id);
    Optional<Deliverer> FindDeliverer(String id);
}
