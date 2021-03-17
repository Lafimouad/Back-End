package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Shelf;

import java.util.List;
import java.util.Optional;

public interface ShelfManagerInterface {
    List<Shelf> retrieveAllShelf();
    Shelf addShelf(Shelf Sh);
    void deleteShelf(Long id);
    void deleteShelf(String id);
    Shelf updateShelf(Shelf Sh);
    Optional<Shelf> FindShelf(Long id);
    Optional<Shelf> FindShelf(String id);
}
