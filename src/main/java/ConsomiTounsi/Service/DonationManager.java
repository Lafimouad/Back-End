package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Donation;

import java.util.List;
import java.util.Optional;

public class DonationManager implements DonationManagerInterface{
    @Override
    public List<Donation> retrieveAllDonation() {
        return null;
    }

    @Override
    public Donation addDonation(Donation Do) {
        return null;
    }

    @Override
    public void deleteDonation(Long id) {

    }

    @Override
    public void deleteDonation(String id) {

    }

    @Override
    public Donation updateDonation(Donation Do) {
        return null;
    }

    @Override
    public Optional<Donation> FindDonation(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Donation> FindDonation(String id) {
        return Optional.empty();
    }
}
