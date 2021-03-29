package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Delivery;

import java.util.List;
import java.util.Optional;
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
    public Delivery updateDeliverer(Delivery De) {
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
}
