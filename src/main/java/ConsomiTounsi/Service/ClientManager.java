package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Client;
import ConsomiTounsi.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientManager implements ClientManagerInterface{
	
	
	
	
	@Autowired 
	ClientRepository Clr ;
	@Override
	
	
	public List<Client> retrieveAllClient() {
		
		return (List<Client>) Clr.findAll();
	}

	@Override
	public Client addClient(Client Cl) {
		
		return Clr.save(Cl);
	}

	@Override
	public void deleteClient(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClient(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client updateClaim(Client Cl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Client> FindClient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Client> FindClient(String id) {
		// TODO Auto-generated method stub
		return null;
	}
   
}
