package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Deliverer;
import ConsomiTounsi.entities.User;

import java.util.List;

public interface DelivererManagerInterface {
	
    List<Deliverer> retrieveAllDeliverer();
    Deliverer addDeliverer(Deliverer D);
    void deleteDelivererById(Long id);
    void deleteDelivererById(String id);
    void updateDeliverer(Deliverer D , String password);
    Deliverer FindDelivererById(Long id);
    Deliverer FindDelivererById(String id);
    long getNbAvailableDeliveres();
	long getNbDeliverer();
	Deliverer getDelivererOfTheMonth();
    double SommeSaliareDeliverer();
    void resetBonus();

    void salaireAvecPrime();
    double updateprimeDeliverer(long id);

    double calculatePrime(long id);

    void electDelivererOftheMonth();

}
