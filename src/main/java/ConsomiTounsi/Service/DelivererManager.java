package ConsomiTounsi.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DelivererManager implements DelivererManagerInterface{
	@Autowired 
	 DelivererRepository Devrr;
    @Override
    public List<Deliverer> retrieveAllDeliverer() {
    	return (List<Delivery>) Devrr.findAll();
    }

    @Override
    public Deliverer addDeliverer(Deliverer D) {
    	return Devrr.save(D);
    }

    @Override
    public void deleteDeliverer(Long id) {
    	Devrr.deleteById(id);
    }

    @Override
    public void deleteDeliverer(String id) {
    	Devrr.deleteById(Long.parseLong(id));
    }

    @Override
    public Deliverer updateDeliverer(Deliverer D) {
    	return Devr.save(D);
    }

    @Override
    public Optional<Deliverer> FindDeliverer(Long id) {
    	return Devrr.findById(id);
    }

    @Override
    public Optional<ConsomiTounsi.entities.Deliverer> FindDeliverer(String id) {
        return Devrr.findById(Long.parseLong(id));
    }
}
