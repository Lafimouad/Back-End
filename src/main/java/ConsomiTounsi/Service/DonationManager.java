package ConsomiTounsi.Service;

import ConsomiTounsi.entities.*;
import ConsomiTounsi.repository.DonationRepository;

import java.util.List;
import java.util.Optional;

import ConsomiTounsi.repository.EventRepository;
import ConsomiTounsi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service 
public class DonationManager implements DonationManagerInterface{
	
	 @Autowired
	    DonationRepository Dor;
    @Autowired
    ProductRepository Pr;
    @Autowired
    EventRepository Ev;

    @Override
    public List<Donation> retrieveAllDonation() {
        return  (List<Donation>) Dor.findAll();
    }

    @Override
    public void addDonation(Donation Do,long idEvent) {
        Dor.save(Do);
        Event eventManagedEntity = Ev.findById(idEvent).get();
        if (ObjectUtils.isEmpty(eventManagedEntity)== false && !ObjectUtils.isEmpty(Do) )
        {Do.setEvent(eventManagedEntity);}
         Product c = Do.getProduct_donation();
        
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
