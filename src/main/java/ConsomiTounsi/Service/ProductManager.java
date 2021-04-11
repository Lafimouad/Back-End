package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.TypeCategory;
import ConsomiTounsi.entities.TypeCriteria;
import ConsomiTounsi.entities.TypeCriteriaValue1;
import ConsomiTounsi.repository.ClientRepository;
import ConsomiTounsi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

@Service
    public class ProductManager implements ProductManagerInterface{
    @Autowired
    ProductRepository Pr;
    
 
    
    
    
    
    
    private EntityManager em;

    @Override
	public EntityManager getEntityManager() {
        return em;
        
    }
    
    @Override
    public List<Product> retrieveAllProducts() {
        return (List<Product>) Pr.findAll();
    }

    @Override
    public Product addProduct(Product P) {
        return Pr.save(P);
    }

    @Override
    public void deleteProduct(Long id) {
        Pr.deleteById(id);

    }

    @Override
    public void deleteProduct(String id) {
        Pr.deleteById(Long.parseLong(id));
    }

    @Override
    public Product updateProduct(Product P) {
        return Pr.save(P);
    }

    @Override
    public Optional<Product> FindProduct(Long id) {
      return   Pr.findById(id);
    }

    @Override
    public Optional<Product> FindProduct(String id) {
      return  Pr.findById(Long.parseLong(id));
    }


    ///// it's the part of her majesty, her highness,mahou moutourat
    
    
    
   /* @Override
	public List<Product> findByCategoryProduct(TypeCategory cp)
    {
    	
    	
    	
		return Pr.findByCategoryProduct(cp);*/
		
		
		
		
		/*@Override
		public void showAdvertsement(TypeCriteria criteria) {
		
		if ( criteria == TypeCriteria.ALL) 
			
			
		{ 	Iterable<Product> products = Pr.findAll() ;
        for (int i=0;i<products.size();i++){

            Product p=products.get(i);
        }
            
		}*/
            
            
		
			
			
			/*{ for(Product product : products)
		printMessage("-------------------------------------------------------------");
        Product product;
		printMessage("Check this product " + product.getNameProduct() );
        printMessage("It only costs " + product.getPriceProduct()  );
   
        printMessage("-------------------------------------------------------------");
			}
    } */
		 
		/*{ return (List<Product>) Pr.findAll();}
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
	
    


	//private void printMessage(String message) {
   // System.out.println(message);


	
		
		


/*//send List of id for her majesty the Nooba maha hail to the king Mouadh
    public List<Long> sendIdClaimedProduct(List<Product> productList){
        List<Long> lass3ed=new ArrayList<Long>();
        for ( Product product : productList ){
            Product  optionalProduct  = Pr.findById(product.getId()).get();
            for (Feedback feedback:optionalProduct.getFeedback()){
                float nb=feedback.getNote();
                if (nb<=2){
                    Long id= product.getId();
                    lass3ed.add(id);
                }

            }

                }


        return lass3ed;
}*/
    
	
	
	
	
	
	
    
    
    
}
