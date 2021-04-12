package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Deliverer;
import ConsomiTounsi.entities.User;

import java.util.List;
import java.util.Optional;

public interface DelivererManagerInterface {
	
	List<Deliverer> retrieveAllDeliverer();
    Deliverer addDeliverer(Deliverer D);
    void DelivererOfTheMonthMail();
    void deleteDelivererById(Long id);
    void deleteDelivererById(String id);
    Deliverer updateDeliverer(Deliverer D);
    //Deliverer FindDelivererById(Long id);
   // Deliverer FindDelivererById(String id);
    //long getNbAvailableDeliveres();
	//long getNbDeliverer();
	//Deliverer getDelivererOfTheMonth();
	//void deleteDeliverer(Long id);
	//void deleteDeliverer(String id);
	Optional<Deliverer> FindDelivererById(Long id);
	Optional<Deliverer> FindDelivererById(String id);
	long FindMaxScore();
  
}
