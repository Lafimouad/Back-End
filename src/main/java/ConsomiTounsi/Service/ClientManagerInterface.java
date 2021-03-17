package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientManagerInterface {
    List<Client> retrieveAllClient();
    Client addClient(Client Cl);
    void deleteClient(Long id);
    void deleteClient(String id);
    Client updateClaim(Client Cl);
    Optional<Client> FindClient(Long id);
    Optional<Client> FindClient(String id);
}
