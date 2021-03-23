package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Claim;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ClaimManagerInterface {
    List<Claim> retrieveAllClaim();
    Claim addClaim(Claim C);
    void deleteClaim(Long id);
    void deleteClaim(String id);
    Claim updateClaim(Claim C);
    Optional<Claim> FindClaim(Long id);
    Optional<Claim> FindClaim(String id);
    Optional<Claim> FindBySubject(String subject);
    Optional<Claim> FindByDate(Date date);
    Claim updateClaimDecision(Claim C);
    Claim updateStatus(Claim C);
    Claim addDecision(Claim C, String decision);
    
}
