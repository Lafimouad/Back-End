package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Admin;
import ConsomiTounsi.entities.Event;
import ConsomiTounsi.entities.Pool;
import ConsomiTounsi.repository.EventRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service  
public class EventManager implements EventManagerInterface{
	
	 @Autowired
	    EventRepository Er; 
	 
	
    @Override
    public List<Event> retrieveAllEvent() {
        return  (List<Event>) Er.findAll();
    }

    @Override
    public Event addEvent(Event E) {
        return  Er.save(E);
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
