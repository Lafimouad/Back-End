package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Pool;

import java.util.List;
import java.util.Optional;

public interface PoolManagerInterface {
    List<Pool> retrieveAllPool();
    Pool addPool(Pool Po);
    void deletePool(Long id);
    void deletePool(String id);
    Pool updatePool(Pool Po);
    Optional<Pool> FindPool(Long id);
    Optional<Pool> FindPool(String id);
}
