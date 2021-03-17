package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Store;

import java.util.List;
import java.util.Optional;

public class StoreManager implements StoreManagerInterface{
    @Override
    public List<Store> retrieveAllStore() {
        return null;
    }

    @Override
    public Store addStore(Store St) {
        return null;
    }

    @Override
    public void deleteStore(Long id) {

    }

    @Override
    public void deleteStore(String id) {

    }

    @Override
    public Store updateStore(Store St) {
        return null;
    }

    @Override
    public Optional<Store> FindStore(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Store> FindStore(String id) {
        return Optional.empty();
    }
}
