package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Deliverer;
import ConsomiTounsi.entities.User;

import java.util.List;

public interface DelivererManagerInterface {
	
    List<Deliverer> retrieveAllDeliverer();
    Deliverer addDeliverer(Deliverer D);
    void deleteDelivererById(Long id);
    void deleteDelivererById(String id);
    Deliverer updateDeliverer(Deliverer D);
    Deliverer FindDelivererById(Long id);
    Deliverer FindDelivererById(String id);
    long getNbAvailableDeliveres();
	long getNbDeliverer();
	Deliverer getDelivererOfTheMonth();
	void deleteDeliverer(Long id);
	void deleteDeliverer(String id);
	Optional<Deliverer> FindDeliverer(Long id);
	Optional<Deliverer> FindDeliverer2(String id);
  
}
