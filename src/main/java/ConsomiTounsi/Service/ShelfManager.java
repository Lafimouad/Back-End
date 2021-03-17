package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Shelf;

import java.util.List;
import java.util.Optional;

public class ShelfManager implements ShelfManagerInterface{
    @Override
    public List<Shelf> retrieveAllShelf() {
        return null;
    }

    @Override
    public Shelf addShelf(Shelf Sh) {
        return null;
    }

    @Override
    public void deleteShelf(Long id) {

    }

    @Override
    public void deleteShelf(String id) {

    }

    @Override
    public Shelf updateShelf(Shelf Sh) {
        return null;
    }

    @Override
    public Optional<Shelf> FindShelf(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Shelf> FindShelf(String id) {
        return Optional.empty();
    }
}
