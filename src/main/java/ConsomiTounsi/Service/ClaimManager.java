package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Claim;
import ConsomiTounsi.repository.ClaimRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaimManager implements ClaimManagerInterface{
	
	@Autowired 
	ClaimRepository Cr;
	
	///////////////// SIMPLE CRUD 
	
	
	
    @Override
    public List<Claim> retrieveAllClaim() {
    	return (List<Claim>) Cr.findAll();
    }

    @Override
    public Claim addClaim(Claim C) {
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
    public Optional<Claim> FindClaim(Long id) {
        return Cr.findById(id) ;
    }

    @Override
    public Optional<Claim> FindClaim(String id) {
        return   Cr.findById(Long.parseLong(id));
    }
    
    
    
    
    ////////////////////// MORE ADVANCED ONES
    
    
    
	@Override
	public Optional<Claim> FindBySubject(String subject) {
		
		return Cr.findBySubject(subject); 
	}

	@Override
	public Optional<Claim> FindByDate(Date date) {
		
		return Cr.findByDate(date); 
	}



	@Override
	public Claim updateClaimDecision(Claim C) {
		C.setDecision(C.getDecision()) ;
		return Cr.save(C);
	}

	@Override
	public Claim updateStatus(Claim C) {
		String Des = C.getDecision(); 
		if (Des.isEmpty()) 
		 C.setStatus("Not Treated");
		else 
		C.setStatus("Treated");
		
		return Cr.save(C) ;
	}

	@Override
	public Claim addDecision(Claim C, String decision) {
		C.setDecision(decision);
		return Cr.save(C) ;
	}
}
