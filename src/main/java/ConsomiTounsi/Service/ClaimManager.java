package ConsomiTounsi.Service;


import ConsomiTounsi.MailClaimAd.MailSending;
import ConsomiTounsi.entities.Claim;
import ConsomiTounsi.repository.ClaimRepository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ClaimManager implements ClaimManagerInterface{
	
	@Autowired 
	ClaimRepository Cr;
	
	
	@Autowired 
	JavaMailSender MailSender ;
	
	@Autowired 
	MailSending Mailsending ;
	
	
	///////////////// SIMPLE CRUD 
	
	
	
    @Override
    public List<Claim> retrieveAllClaim() {
    	return (List<Claim>) Cr.findAll();
    }

    @Override
    public Claim addClaim(Claim C) {
    	String Description = C.getDescription();
    	if (Description.toLowerCase().indexOf("angry",0) > 0 || Description.toLowerCase().indexOf("worst",0) > 0 || Description.toLowerCase().indexOf("urgent",0) > 0) 
    		{ C.setLevel(1); }
    	else if (Description.toLowerCase().indexOf("disappointed",0) > 0 || Description.toLowerCase().indexOf("medium",0) > 0 || Description.toLowerCase().indexOf("damaged",0) > 0) 
    		{ C.setLevel(2); }
    	else
    	    { C.setLevel(3); }
    		
    		
    	C.setStatus("Not Treated");
        return Cr.save(C);
    }

    @Override
    public void deleteClaim(Long id) {
    	 Cr.deleteById(id);

    }

    @Override
    public void deleteClaim(String id) {
    	  Cr.deleteById(Long.parseLong(id));

    }

    @Override
    public Claim updateClaim(Claim C) {
        return Cr.save(C);
    }

    @Override
    public Claim FindClaim (Long id) {
        return Cr.findById(id).orElse(null);
    }

    @Override
    public Optional<Claim> FindClaim2(String id) {
        return   Cr.findById(Long.parseLong(id));
    }
    
    
    
    
    ////////////////////// MORE ADVANCED ONES
    
    
    
	@Override
	public Optional<Claim> FindBySubject(String subject) {
		
		return Cr.findBysubject(subject); 
	}
	
	
	
	@Override
	public Optional<Claim> FindByStatus(String status) {
		
		return Cr.findBystatus(status); 
	}

	@Override
	public Optional<Claim> FindByDate(Date date) {
		
		return Cr.findByDate(date); 
	}



	@Override
	public Claim updateClaimDecision(Claim C) {
		
		//if (C.getSubject() == system)
		
		
		
		
		String treatement2 = "Treated" ;
		String Des = C.getDecision(); 
		if (Des != null) {
			C.setStatus(treatement2); }
		String subject = "Claim Response";
		String to = "maha.themri1@esprit.tn" ;
		//String body = "Your claim got answered, Please check our website" ;
		/*String description = C.getDescription() ;
		Mailsending.sendEmail(to , body(description) ,subject ) ;*/
		return Cr.save(C);
	}
	
	
	 
	 public String body(String description){
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
	                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Consomi Tounsi #619</span>\n" +
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
	                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> the product " + description + "'s quantity is less than 10 items , it's about time to contact the supplier</p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\">" +
	                "  \n" +
	                "      </td>\n" +
	                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
	                "    </tr>\n" +
	                "    <tr>\n" +
	                "      <td height=\"30\"><br></td>\n" +
	                "    </tr>\n" +
	                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
	                "\n" +
	                "</div></div>";
	 }
	
	
	/*@Override
	public void SendEmail () {
		SimpleMailMessage Smm = new SimpleMailMessage();
		Smm.setFrom("consomitounsiwebsite@gmail.com");
		Smm.setTo("mahethemri@gmail.com");
		Smm.setSubject("Claim Space");
		Smm.setText("Your Claim has been verified and answered, Check your Client Space to get your answer");
		MailSender.send(Smm);
		}*/
	
	
		

	/*@Override
	public void updateStatus() {
		for (Claim calimouta : (List<Claim>) Cr.findAll()) {
		String treatement = "Not Treated" ;
		String treatement2 = "Treated" ;
		String Des = calimouta.getDecision(); 
		if (Des== null) {
			calimouta.getStatus() ;
			calimouta.setStatus(treatement); }
		else {
			calimouta.getStatus() ;
			calimouta.setStatus(treatement2);} 
		
	    Cr.save(calimouta) ; }
		
	}*/

	/*@Override
	public Claim addDecision(Claim C, String decision) {
		C.setDecision(decision);
		return Cr.save(C) ;
	}*/

	/*@Override
	public Optional<Claim> FindClaim3(Long idUser) {
		return Cr.findByIdUser(idUser) ;
	}*/
	
	@Override 
	public Long CountClaims() {
		return Cr.getNumberOfClaims();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Override
	public Claim updateStatus(Long id) {
		Claim calimouta = Cr.findById(id).orElse(null) ;
		String treatement = "Not Treated" ;
		String treatement2 = "Treated" ;
		String Des = calimouta.getDecision(); 
		if (Des== null) {
			calimouta.getStatus() ;
			calimouta.setStatus(treatement); }
		else {
			calimouta.getStatus() ;
			calimouta.setStatus(treatement2);}
		
		return Cr.save(calimouta) ;
	}*/
}
