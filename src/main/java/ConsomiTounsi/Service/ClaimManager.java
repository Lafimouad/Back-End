package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Claim;
import ConsomiTounsi.entities.Product;
import ConsomiTounsi.repository.ClaimRepository;
import ConsomiTounsi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClaimManager implements ClaimManagerInterface {

    @Autowired
    ClaimRepository Cr;


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
        return Cr.save(C);
    }

    @Override
    public Optional<Claim> FindClaim(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Claim> FindClaim(String id) {
        return Optional.empty();
    }

    // counting number of claims for a given product
    public int claimsNumber(Long Bp) {
        int Nb = 0;
        for (Claim claim : Cr.findAll()) {
            if (claim.getProductWithProb() == Bp) {
                Nb += 1;
            }
        }
        return Nb;
    }


    @Autowired
    ProductRepository Pr;
    @Autowired
    ProductManager productManager;


    // get products with 10 claims to block them
    public List<Long> WorstProducts() {
        List<Product> elProducts = (List<Product>) Pr.findAll();
        List<Long> idfeedback = productManager.sendIdClaimedProduct();
        List<Long> Worst = new ArrayList<>();
        for (Long theId : idfeedback) {
            int ClaimNumber = claimsNumber(theId);
            if (ClaimNumber > 10) {
                Worst.add(theId);
            }

        }
        return Worst;
    }
}
