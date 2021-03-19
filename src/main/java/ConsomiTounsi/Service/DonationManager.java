package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Donation;
import ConsomiTounsi.repository.DonationRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class DonationManager implements DonationManagerInterface{
	
	 @Autowired
	    DonationRepository Dor; 
    @Override
    public List<Donation> retrieveAllDonation() {
        return null;
    }

    @Override
    public Donation addDonation(Donation Do) {
        return null;
    }

    @Override
    public void deleteDonation(Long id) {

    }

    @Override
    public void deleteDonation(String id) {

    }

    @Override
    public Donation updateDonation(Donation Do) {
        return null;
    }

    @Override
    public Optional<Donation> FindDonation(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Donation> FindDonation(String id) {
        return Optional.empty();
    }
}
