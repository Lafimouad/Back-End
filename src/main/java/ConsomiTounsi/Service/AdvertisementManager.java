package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Advertisement;
import ConsomiTounsi.entities.Client;
import ConsomiTounsi.entities.Gender;

import ConsomiTounsi.entities.WorkField;
import ConsomiTounsi.Mail.EmailSenderService;

import ConsomiTounsi.entities.TypeCategory;
import ConsomiTounsi.entities.Product;

import ConsomiTounsi.repository.ProductRepository;
import ConsomiTounsi.repository.AdvertisementRepository;
import ConsomiTounsi.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
@Service
public class AdvertisementManager implements AdvertisementManagerInterface{
  
	@Autowired
	AdvertisementRepository Adr;
	
	@Autowired
	 ProductRepository Pr;
	
	@Autowired
	 ClientRepository Clr;
	
	 
	
	
	 
	////////////////////////////Simple CRUD 
	
	
	
    @Override
    public List<Advertisement> retrieveAllAdvertisement() {
    	return (List<Advertisement>) Adr.findAll();
    }
   
    
    @Override
    public Advertisement addAdvertisement(Advertisement Ad)  {
	
       return Adr.save(Ad) ;
       
     }
    
    
    
    @Override
    public void deleteAdvertisement(Long id) {
    	 Adr.deleteById(id);
    }

    @Override
    public void deleteAdvertisement(String id) {
    	Adr.deleteById(Long.parseLong(id));
    }

    @Override
    public Advertisement updateChanel(Advertisement Ad, Long id) {
    	  Advertisement advertisementById = Adr
                  .findById(id)
                  .orElse(null) ;

         
          advertisementById.setChannel(Ad.getChannel());
          return Adr.save(Ad) ;
    }

    @Override
    public Advertisement FindAdvertisement(Long id) {
    	return Adr.findById(id).orElse(null);
    }

    @Override
    public Optional<Advertisement> FindAdvertisement(String id) {
        return Adr.findById(Long.parseLong(id));
    }

	@Override
	public Advertisement updateAdvertisement(Advertisement Ad) {
	
         
		return Adr.save(Ad);
	}

	

	
	
	
	
	///////////////////////////////More Advanced ones 
	
	
	
	
	@Override
	public List<Product> showAdvertsementByCategory(TypeCategory cp) {
		
		Iterable<Client> clients = Clr.findAll() ;
		List<Product> F = Pr.findByCategoryProduct(cp);
		List<Product> M = Pr.findByCategoryProduct2(cp);
		List<Product> H = Pr.findByCategoryProduct5(cp);
		List<Product> S = Pr.findByCategoryProduct4(cp);
		List<Product> c = new ArrayList<>() ;
		for (Client client : clients){
			
            Gender genderClient = client.getGenderClient();
            WorkField workfieldClient = client.getWorkfieldClient();
            	if ( genderClient == Gender.MALE) {
            		if (workfieldClient == WorkField.EDUCATION)
            	  {c = M; }
            		if (workfieldClient == WorkField.COSMETICS) {
            			{c= H ;}
            		}
            	}
            	if (genderClient==Gender.FEMALE)
            	{
            		if (workfieldClient == WorkField.EDUCATION)
              	  {c = F; }
              		if (workfieldClient == WorkField.COSMETICS) {
              			{c= S ;}
              		}
            	}
            		
		}
		return c ;
	}
	
	
	
	
	
	
	
	
	@Override	
	public String CountAdDays(Long id) {
	 Advertisement TargetedAd = Adr.findById(id).orElse(new Advertisement()) ;
	 SimpleDateFormat sdf
     = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	 Date endDate = TargetedAd.getEnddate() ;
	 Date date = new Date();
	long Difference = endDate.getTime() - date.getTime() ; 
	int minutes = (int) (Difference / (1000 * 60 ));
	Long TheId = TargetedAd.getIdAdvertisment();
	 
	 return " The advertisement that has the id  " +TheId+ " has :" + " \n" +minutes+ " minutes left " ; 
		
		
   	 
   }
	
	
	
		
		
		
   
            
           
	
	
	
	
	
	
	
}

	
	
	
	
	

	

	

	
