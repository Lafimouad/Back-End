package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Advertisement;
import ConsomiTounsi.entities.Client;
import ConsomiTounsi.entities.Gender;
import ConsomiTounsi.entities.TypeCriteria;
import ConsomiTounsi.entities.TypeCriteriaValue1;
import ConsomiTounsi.entities.WorkField;
import ConsomiTounsi.Service.ProductManager;
import ConsomiTounsi.entities.TypeCategory;
import ConsomiTounsi.entities.Product;

import ConsomiTounsi.repository.ProductRepository;
import ConsomiTounsi.repository.AdvertisementRepository;
import ConsomiTounsi.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
	
	
	
	 /*@Autowired
	EntityManagerFactory factory = Persistence.createEntityManagerFactory(null);
	 EntityManager em = factory.createEntityManager();*/
	 
	////////////////////////////Simple CRUD 
	
	
	
    @Override
    public List<Advertisement> retrieveAllAdvertisement() {
    	return (List<Advertisement>) Adr.findAll();
    }

    @Override
    public Advertisement addAdvertisement(Advertisement Ad) {
    	Advertisement optionalAdvertisement = Adr.save(Ad) ;
       return optionalAdvertisement ;
       
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
	//public List<Product> showAdvertsementByCategory(TypeCategory cp) {
		
		
	
	
	
		
		
		
   
            
           
	
	
	
	
	
	/*@Override
	public List<Product> findByCategoryProduct(TypeCategory cp) {
		return ((AdvertisementManager) Pr).findByCategoryProduct(cp);
	}*/
	
	/*@Override
	public List<Product> showAdvertsementForAll( TypeCriteria criteria) {
	
	if ( criteria == TypeCriteria.ALL) 
		
		return Pr.
	 
	{ return (List<Product>) Pr.findAll();}
	else 
	if ( criteria == TypeCriteria.GENDER)
		{
		if (criteriaValue1== TypeCriteriaValue1.MALE)
		
			{return }
		else if (criteriaValue2== TypeCriteriaValue2.FEMALE)
			{return}
		}
		
	else 
	if ( criteria == TypeCriteria.WorkField)
		
	}*/
	
	/*public Query showAdvertsementByCategoryFemale( TypeCategory categoryProduct)
	{
	String jpql = 
		    "select p from Product p"
		    + " where f.categoryProduct = :categoryProduct" ;
		Query query = em.createQuery(jpql);
		query.setParameter("categoryProduct", categoryProduct.makeUp);
		
		return query ;
}
	*/
	

	// sammih li theb 3lih, hot fih lhajtin hekom
	
	/*Client haja = optionalAdvertisement.getClient() ;
    haja.getGenderClient() ;*/

	
	
	
	
}

	
	
	
	
	

	

	

	
