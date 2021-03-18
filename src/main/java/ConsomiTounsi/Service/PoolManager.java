package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Pool;
import ConsomiTounsi.repository.PoolRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PoolManager implements PoolManagerInterface{
	
	 @Autowired
	    PoolRepository Poolr; 
	 
    @Override
    public List<Pool> retrieveAllPool() {
        return null;
    }

    @Override
    public Pool addPool(Pool Po) {
        return null;
    }

    @Override
    public void deletePool(Long id) {

    }

    @Override
    public void deletePool(String id) {

    }

    @Override
    public Pool updatePool(Pool Po) {
        return null;
    }

    @Override
    public Optional<Pool> FindPool(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Pool> FindPool(String id) {
        return Optional.empty();
    }
}
