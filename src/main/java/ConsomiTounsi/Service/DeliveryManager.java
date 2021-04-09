package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Delivery;
import ConsomiTounsi.entities.DurationOfDelivering;
import ConsomiTounsi.entities.QualityOfDelivering;
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
    	String Service = D.getService_delivery();
    	DurationOfDelivering Duration = D.getDuration_delivery();
    	int Score = D.getScoreDelivery();
    	if ( Quality == QualityOfDelivering.good )
    		{Score=+1; }
    	else if ( Quality == QualityOfDelivering.great )
    	    {Score=+2; }
    	else if  ( Quality == QualityOfDelivering.bad )
		{Score=-1; }
    	else if  ( Quality == QualityOfDelivering.awful)
		{Score=-2; }
    	else if  ( Service == "1")
		{Score=+1; }
    	else if  ( Service == "2")
		{Score=+2; }
    	else if  ( Service == "3")
		{Score=Score + 3 ;}
    	else if  ( Service == "4")
		{Score= Score + 4 ;}
    	else if  ( Service == "5")
		{Score= Score + 5 ;}
    	else if ( Duration ==DurationOfDelivering.absent )
	    {Score= Score - 3 ; }
    	else if ( Duration ==DurationOfDelivering.late )
	    {Score= Score - 1 ; }
    	else if ( Duration ==DurationOfDelivering.punctual )
	    {Score= Score + 2 ; }
    	return Score; 
    } 

}
