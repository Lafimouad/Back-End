package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Client;

import java.util.List;

public interface ClientManagerInterface {
	
    List<Client> retrieveAllClient();
    void deleteClientById(Long id);
    void deleteClientById(String id);
    Client updateClient(Client Cl);
    Client FindClientById(Long id);
    Client FindClientById(String id);
    long getNombreClient();

    Client SignUpClient(Client user);
}
