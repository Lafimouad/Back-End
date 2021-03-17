package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Store;

import java.util.List;
import java.util.Optional;

public interface StoreManagerInterface {
    List<Store> retrieveAllStore();
    Store addStore(Store St);
    void deleteStore(Long id);
    void deleteStore(String id);
    Store updateStore(Store St);
    Optional<Store> FindStore(Long id);
    Optional<Store> FindStore(String id);
}
