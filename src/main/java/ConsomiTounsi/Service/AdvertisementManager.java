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



import java.util.ArrayList;
import java.util.Collection;
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
	
	  private JavaMailSender javaMailSender;
	    @Autowired
	    public AdvertisementManager(JavaMailSender javaMailSender)
	    {
	        this.javaMailSender=javaMailSender;
	    }
	
	 /*@Autowired
	EntityManagerFactory factory = Persistence.createEntityManagerFactory(null);
	 EntityManager em = factory.createEntityManager();*/
	 
	////////////////////////////Simple CRUD 
	
	
	
    @Override
    public List<Advertisement> retrieveAllAdvertisement() {
    	return (List<Advertisement>) Adr.findAll();
    }
    @Autowired
    EmailSenderService emailSenderService;
    
    @Override
    public Advertisement addAdvertisement(Advertisement Ad) throws MessagingException {
		//String subject = "Claim Response";
		//String to = "maha.themri1@esprit.tn" ;
		//emailSenderService.sendEmail(to, body(), subject);
    	 this.sendEmail("maha.themri1@esprit.tn","done");
       return Adr.save(Ad) ;
       
     }
    
    
    /*public String body(){
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Welcome to Consomi Tounsi #619</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#7C0A02\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> The following are the default credentials you can use to log in to your account that you can change later on <br> Username : " + " <br> Password : " + "</p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\">" +
                "  \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";}*/

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

	
	public void sendEmail(String sendTo,String text) throws MailException {
	
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(sendTo);
        simpleMailMessage.setFrom("consommitounsi2@gmail.com");
        simpleMailMessage.setSubject("Payment");
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);
        
	}
}

	
	
	
	
	

	

	

	
