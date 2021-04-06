package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Donation;

import java.util.List;
import java.util.Optional;

public interface DonationManagerInterface {
    List<Donation> retrieveAllDonation();
    Donation addDonation(Donation Do);
    void deleteDonation(Long id);
    void deleteDonation(String id);
    Donation updateDonation(Donation Do);
    public Donation FindDonationById(Long id);
    public Donation FindDonationById(String id);
}
