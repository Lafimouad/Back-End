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
	DelivererRepository Der;
   @Override
   public List<Deliverer> retrieveAllDeliverer() {
   	return (List<Deliverer>) Der.findAll();
   }

   @Override
   public Deliverer addDeliverer(Deliverer D) {
   	return Der.save(D);
   }

   @Override
   public void deleteDelivererById(Long id) {
   	Der.deleteById(id);
   }

   @Override
   public void deleteDelivererById(String id) {
   	Der.deleteById(Long.parseLong(id));
   }

   @Override
   public Deliverer updateDeliverer(Deliverer D) {
   	return Der.save(D);
   }

   @Override
   public Optional<Deliverer> FindDelivererById(Long id) {
   	return Der.findById(id);
   }

   @Override
   public Optional<Deliverer> FindDelivererById(String id) {
       return Der.findById(Long.parseLong(id));
   }
   
   public Long FindMaxScore() {
       return Der.getMaxScore();
   }
}
