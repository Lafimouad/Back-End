package ConsomiTounsi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ConsomiTounsi.entities.Deliverer;
import ConsomiTounsi.repository.DelivererRepository;
@Service
public class DelivererManager implements DelivererManagerInterface{
	@Autowired 
	 DelivererRepository Devrr;
    @Override
    public List<Deliverer> retrieveAllDeliverer() {
    	return (List<Deliverer>) Devrr.findAll();
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
    	return Devrr.save(D);
    }

    @Override
    public Optional<Deliverer> FindDeliverer(Long id) {
    	return Devrr.findById(id);
    }

    @Override
    public Optional<Deliverer> FindDeliverer2(String id) {
        return Devrr.findById(Long.parseLong(id));
    }
    
   /* @Override
    public List<Deliverer> showAvailableDeliverers(){
        return Devrr.findAvailableDeliverers();
    }*/
}
