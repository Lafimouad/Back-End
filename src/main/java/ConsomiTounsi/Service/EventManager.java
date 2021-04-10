package ConsomiTounsi.Service;

import ConsomiTounsi.entities.*;
import ConsomiTounsi.repository.ClientRepository;
import ConsomiTounsi.repository.EventRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import ConsomiTounsi.repository.PoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;


@Service  
public class EventManager implements EventManagerInterface{
	
	 @Autowired
	    EventRepository Er;
	 @Autowired
        PoolRepository Poor;
	 @Autowired
       ClientRepository Clr;


	
    @Override
    public List<Event> retrieveAllEvent() {
        return  (List<Event>) Er.findAll();
    }

    @Override
    public Event addEvent1(Event E) {
        return Er.save(E);
    }

    @Override
    public Event addEvent(Event E , long id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        E.setDate_event(now);
        Event optionalEvent = new Event() ;
        Pool p = Poor.findById(id).orElse(new Pool());
        double amountPool = p.getAmount_pool();
        double amountEvent = E.getRaisedAmount_event();
        if (amountPool>amountEvent)
        {double a = amountPool - amountEvent;
        p.setAmount_pool(a);
        optionalEvent = Er.save(E) ;
        }
        else {
            throw new IllegalStateException("the pool amount is not enough to organise an event");
        }
        return optionalEvent;

    }


    public void addClientToEvent (Long id , List<Client> clientsList){
        for ( Client client : clientsList ){
            Optional<Client > optionalClient  = Clr.findById(client.getId());
            if ( ! optionalClient.isPresent()){
               // return  new ResponseEntity<>( new MessageResponseModel( " The Product with Id  "+ product.getId()
                     //   +"Does not exist "), HttpStatus.BAD_REQUEST );
                throw new IllegalStateException("the client with this Id is not exist");
            }

            Optional<Event> optionalEvent = Er.findById(id);

            if ( !optionalEvent.isPresent()){
                throw new IllegalStateException("the event with this Id is not exist");

            }

            Event event =  optionalEvent.get();

            order.addproducts(product);
            event.
        }
        return  new ResponseEntity<>( HttpStatus.OK);}




    @Override
    public void deleteEvent(Long id) {
        Er.deleteById(id);
    }

    @Override
    public void deleteEvent(String id) {
        Er.deleteById(Long.parseLong(id));
    }

    @Override
    public Event updateEvent(Event E) {
        return Er.save(E) ;
    }

    @Override
    public Event FindEventById(Long id) {
        return Er.findById(id).orElse(new Event());
    }

    @Override
    public Event FindEventById(String id) {
        return Er.findById(Long.parseLong(id)).orElse(new Event());
    }
}
