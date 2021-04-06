package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Advertisement;
import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.TypeCategory;
import ConsomiTounsi.entities.TypeCriteria;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

public interface AdvertisementManagerInterface {
    List<Advertisement> retrieveAllAdvertisement();
    Advertisement addAdvertisement(Advertisement Ad);
    void deleteAdvertisement(Long id);
    void deleteAdvertisement(String id);
    Advertisement updateChanel(Advertisement Ad, Long id);
    Advertisement updateAdvertisement(Advertisement Ad);
    Advertisement FindAdvertisement(Long id);
    Optional<Advertisement> FindAdvertisement(String id);
    //List<Product>findByCategoryProduct(TypeCategory cp);
    //List<Product> showAdvertsementForAll(TypeCriteria criteria);
    List<Product> showAdvertsementByCategory( TypeCategory cp);
   
}
