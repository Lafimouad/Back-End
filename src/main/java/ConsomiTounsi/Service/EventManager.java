package ConsomiTounsi.Service;

import ConsomiTounsi.entities.*;
import ConsomiTounsi.repository.EventRepository;

import java.util.List;
import java.util.Optional;

import ConsomiTounsi.repository.PoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service  
public class EventManager implements EventManagerInterface{
	
	 @Autowired
	    EventRepository Er;
	 @Autowired
        PoolRepository Poor;


	
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
        Event optionalEvent = new Event() ;
        Pool p = Poor.findById(id).orElse(new Pool());
        double amountPool = p.getAmount_pool();
        double amountEvent = E.getRaisedAmount_event();
        if (amountPool>amountEvent)
        {double a = amountPool - amountEvent;
        p.setAmount_pool(a);
        optionalEvent = Er.save(E) ;}
        return optionalEvent;

    }

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
