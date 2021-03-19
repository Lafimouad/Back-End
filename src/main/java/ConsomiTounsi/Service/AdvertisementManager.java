package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Advertisement;
import ConsomiTounsi.repository.ClaimRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdvertisementManager implements AdvertisementManagerInterface{
  
	@Autowired
	ClaimRepository Adr;
	
    @Override
    public List<Advertisement> retrieveAllAdvertisement() {
        return null;
    }

    @Override
    public Advertisement addAdvertisement(Advertisement Ad) {
        return null;
    }

    @Override
    public void deleteAdvertisement(Long id) {

    }

    @Override
    public void deleteAdvertisement(String id) {

    }

    @Override
    public Advertisement updateAdvertisement(Advertisement Ad) {
        return null;
    }

    @Override
    public Optional<Advertisement> FindAdvertisement(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Advertisement> FindAdvertisement(String id) {
        return Optional.empty();
    }
}
