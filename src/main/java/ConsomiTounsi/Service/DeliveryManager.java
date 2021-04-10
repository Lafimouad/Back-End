package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Delivery;
import ConsomiTounsi.entities.DurationOfDelivering;
import ConsomiTounsi.entities.QualityOfDelivering;
import ConsomiTounsi.entities.ServiceDelivering;
import ConsomiTounsi.repository.DeliveryRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DeliveryManager implements DeliveryManagerInterface{
	@Autowired 
	 DeliveryRepository Devr;
    @Override
    public List<Delivery> retrieveAllDelivery() {
    	return (List<Delivery>) Devr.findAll();
    }
    
    @Override
    public Delivery addDelivery(Delivery De) {
    	return Devr.save(De);
    }

    @Override
    public void deleteDelivery(Long id) {
    	Devr.deleteById(id);
    }

    @Override
    public void deleteDelivery(String id) {
    	Devr.deleteById(Long.parseLong(id));
    }

    @Override
    public Delivery updateDelivery(Delivery De) {
    	return Devr.save(De);
    }

    @Override
    public Optional<Delivery> FindDelivery(Long id) {
    	return Devr.findById(id);
    }

    @Override
    public Optional<Delivery> FindDelivery(String id) {
    	return Devr.findById(Long.parseLong(id));
    }
    
    public int CalculateScore(Delivery D) {
    	
    	QualityOfDelivering Quality = D.getQuality_delivery();
    	ServiceDelivering Service = D.getService_delivery();
    	DurationOfDelivering Duration = D.getDuration_delivery();
    	int Score = D.getScoreDelivery();
    	Score=0; 
    	if ( Quality == QualityOfDelivering.good )
    		{Score=Score+1; }
    	System.out.println("Score:"+Score);

    	if ( Quality == QualityOfDelivering.great )
    	    {Score=Score+3; }
    	System.out.println("Score:"+Score);
    	 if  ( Quality == QualityOfDelivering.bad )
		{Score=Score-1; }
     	System.out.println("Score:"+Score);

    	if  ( Quality == QualityOfDelivering.awful)
		{Score=Score-2; }
    	System.out.println("Score:"+Score);

    	if  ( Service == ServiceDelivering.one)
		{Score=Score+1; }
    	System.out.println("Score:"+Score);

    	if  ( Service == ServiceDelivering.two)
		{Score=Score+2; }
    	System.out.println("Score:"+Score);

    	if  (Service == ServiceDelivering.three)
		{Score=Score+3 ;}
    	System.out.println("Score:"+Score);

    	if  (Service == ServiceDelivering.four)
		{Score=Score+4 ;}
    	System.out.println("Score:"+Score);

    	 if  (Service == ServiceDelivering.five)
		{Score=Score+5 ;}
     	System.out.println("Score:"+Score);

    	  if ( Duration ==DurationOfDelivering.absent )
	    {Score=Score-3 ; }
      	System.out.println("Score:"+Score);

    	 if ( Duration ==DurationOfDelivering.late )
	    {Score=Score-1 ; }
     	System.out.println("Score:"+Score);

    	 if ( Duration ==DurationOfDelivering.punctual )
	    {Score=Score+2 ; }
     	System.out.println("Score:"+Score);
     	D.setScoreDelivery(Score);
     	Devr.save(D);
     	
    	return Score; }}