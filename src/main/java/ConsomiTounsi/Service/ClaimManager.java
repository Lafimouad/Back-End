package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Claim;

import java.util.List;
import java.util.Optional;

public class ClaimManager implements ClaimManagerInterface{
    @Override
    public List<Claim> retrieveAllClaim() {
        return null;
    }

    @Override
    public Claim addClaim(Claim C) {
        return null;
    }

    @Override
    public void deleteClaim(Long id) {

    }

    @Override
    public void deleteClaim(String id) {

    }

    @Override
    public Claim updateClaim(Claim C) {
        return null;
    }

    @Override
    public Optional<Claim> FindClaim(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Claim> FindClaim(String id) {
        return Optional.empty();
    }
}
