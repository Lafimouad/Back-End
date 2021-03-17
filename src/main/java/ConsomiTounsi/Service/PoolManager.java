package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Pool;

import java.util.List;
import java.util.Optional;

public class PoolManager implements PoolManagerInterface{
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
