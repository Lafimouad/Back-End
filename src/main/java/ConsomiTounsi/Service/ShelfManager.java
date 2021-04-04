package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.Shelf;
import ConsomiTounsi.entities.typeShelf;
import ConsomiTounsi.repository.ProductRepository;
import ConsomiTounsi.repository.ShelfRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;


@Service
public class ShelfManager implements ShelfManagerInterface{
	
	 @Autowired
	    ShelfRepository Shr;
    @Autowired
    ProductRepository Pdr;
	 
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

	@Override
	public List<Shelf> FindShelfByType(typeShelf type) {
    	return Shr.FindShelfByType(type);

	}

    @Transactional
    public void AffectProductAShelf(long shelfId, long productId) {

        Shelf shelfManagedEntity = Shr.findById(shelfId).get();
        Product prodManagedEntity = Pdr.findById(productId).get();


        if (ObjectUtils.isEmpty(shelfManagedEntity)== false && !ObjectUtils.isEmpty(prodManagedEntity) )
        {prodManagedEntity.setShelf(shelfManagedEntity);}

    }

    public List<String> getAllProductsNamesByShelf(long shelfId) {
        Shelf shelfManagedEntity = Shr.findById(shelfId).get();
        List<String> prodNames = new ArrayList<>();
        for(Product prod : shelfManagedEntity.getProduct()){
            prodNames.add(prod.getName_product());
        }

        return prodNames;
    }




}
