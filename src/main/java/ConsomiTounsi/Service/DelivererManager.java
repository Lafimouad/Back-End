package ConsomiTounsi.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ConsomiTounsi.entities.Deliverer;
import ConsomiTounsi.repository.DelivererRepository;

@Service
public class DelivererManager implements DelivererManagerInterface{

	@Autowired
	DelivererRepository dr;
	
	@Override
	public List<Deliverer> retrieveAllDeliverer() {
        return (List<Deliverer>) dr.findAll();
	}

	@Override
	public Deliverer addDeliverer(Deliverer D) {
		return dr.save(D);
	}

	@Override
	public void deleteDelivererById(Long id) {
        dr.deleteById(id);
		
	}

	@Override
	public void deleteDelivererById(String id) {
		dr.deleteById(Long.parseLong(id));		
	}

	@Override
	public Deliverer updateDeliverer(Deliverer D) {
		return dr.save(D);
	}

	@Override
	public Deliverer FindDelivererById(Long id) {
		return  dr.findById(id).orElse(new Deliverer());
	}

	@Override
	public Deliverer FindDelivererById(String id) {
		return  dr.findById(Long.parseLong(id)).orElse(new Deliverer());
	}

	@Override
	public long getNbAvailableDeliveres() {
		return dr.getNbAvailableDeliveres();
	}

	@Override
	public long getNbDeliverer() {
		return dr.getNbDeliverer();
	}

	@Override
	public Deliverer getDelivererOfTheMonth() {
		return dr.getDelivererOfTheMonth();
	}

}
