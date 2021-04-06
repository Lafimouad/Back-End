package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Donation;
import ConsomiTounsi.entities.Event;
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
        return  (List<Donation>) Dor.findAll();
    }

    @Override
    public Donation addDonation(Donation Do) {
        return  Dor.save(Do);

    }

    @Override
    public void deleteDonation(Long id) {
        Dor.deleteById(id);
    }

    @Override
    public void deleteDonation(String id) {
        Dor.deleteById(Long.parseLong(id));
    }

    @Override
    public Donation updateDonation(Donation Do) {
        return Dor.save(Do) ;
    }

    @Override
    public Donation FindDonationById(Long id) {
        return Dor.findById(id).orElse(new Donation());
    }

    @Override
    public Donation FindDonationById(String id) {
        return Dor.findById(Long.parseLong(id)).orElse(new Donation());
    }
}
