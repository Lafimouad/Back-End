package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Advertisement;

import java.util.List;
import java.util.Optional;

public interface AdvertisementManagerInterface {
    List<Advertisement> retrieveAllAdvertisement();
    Advertisement addAdvertisement(Advertisement Ad);
    void deleteAdvertisement(Long id);
    void deleteAdvertisement(String id);
    Advertisement updateAdvertisement(Advertisement Ad);
    Optional<Advertisement> FindAdvertisement(Long id);
    Optional<Advertisement> FindAdvertisement(String id);
}
