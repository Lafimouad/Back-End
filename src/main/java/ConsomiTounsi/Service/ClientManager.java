package ConsomiTounsi.Service;
import ConsomiTounsi.entities.Client;

import java.util.List;
import java.util.Optional;

public class ClientManager implements ClientManagerInterface{

    @Override
    public List<Client> retrieveAllClient() {
        return null;
    }

    @Override
    public Client addClient(Client Cl) {
        return null;
    }

    @Override
    public void deleteClient(Long id) {

    }

    @Override
    public void deleteClient(String id) {

    }

    @Override
    public Client updateClaim(Client Cl) {
        return null;
    }

    @Override
    public Optional<Client> FindClient(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> FindClient(String id) {
        return Optional.empty();
    }
}
