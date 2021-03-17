package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Claim;

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
}
