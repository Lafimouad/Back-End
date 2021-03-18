package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Event;
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
        return null;
    }

    @Override
    public Event addEvent(Event E) {
        return null;
    }

    @Override
    public void deleteEvent(Long id) {

    }

    @Override
    public void deleteEvent(String id) {

    }

    @Override
    public Event updateEvent(Event E) {
        return null;
    }

    @Override
    public Optional<Event> FindEvent(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Event> FindEvent(String id) {
        return Optional.empty();
    }
}
