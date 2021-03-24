package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.Shelf;
import ConsomiTounsi.repository.ShelfRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShelfManager implements ShelfManagerInterface{
	
	 @Autowired
	    ShelfRepository Shr;
	 
    @Override
    public List<Shelf> retrieveAllShelf() {
        return (List<Shelf>) Shr.findAll();
    }

    @Override
    public Shelf addShelf(Shelf Sh) {
        return Shr.save(Sh);
    }

    @Override
    public void deleteShelf(Long id) {
    	Shr.deleteById(id);

    }

    @Override
    public void deleteShelf(String id) {
    	Shr.deleteById(Long.parseLong(id));

    }

    @Override
    public Shelf updateShelf(Shelf Sh) {
        return Shr.save(Sh);
    }

    @Override
    public Optional<Shelf> FindShelf(Long id) {
        return   Shr.findById(id);
    }

    @Override
    public Optional<Shelf> FindShelf(String id) {
        return  Shr.findById(Long.parseLong(id));
    }
}
