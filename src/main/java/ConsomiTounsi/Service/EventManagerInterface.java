package ConsomiTounsi.Service;


import ConsomiTounsi.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventManagerInterface {
    List<Event> retrieveAllEvent();
    Event addEvent(Event E);
    void deleteEvent(Long id);
    void deleteEvent(String id);
    Event updateEvent(Event E);
    Optional<Event> FindEvent(Long id);
    Optional<Event> FindEvent(String id);
}
