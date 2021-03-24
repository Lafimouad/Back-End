package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Client;
import ConsomiTounsi.repository.ClientRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientManager implements ClientManagerInterface{

	@Autowired
	ClientRepository cr;
	
	@Override
	public List<Client> retrieveAllClient() {
        return (List<Client>) cr.findAll();
	}

	@Override
	public Client addClient(Client Cl) {
		return cr.save(Cl);
	}

	@Override
	public void deleteClientById(Long id) {
        cr.deleteById(id);
	}

	@Override
	public void deleteClientById(String id) {
        cr.deleteById(Long.parseLong(id));		
	}

	@Override
	public Client updateClient(Client Cl) {
		return cr.save(Cl);
	}

	@Override
	public Client FindClientById(Long id) {
		return  cr.findById(id).orElse(new Client());
	}

	@Override
	public Client FindClientById(String id) {
		return  cr.findById(Long.parseLong(id)).orElse(new Client());
	}

}
