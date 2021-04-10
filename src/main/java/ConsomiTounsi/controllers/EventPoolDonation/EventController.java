package ConsomiTounsi.controllers.EventPoolDonation;

import ConsomiTounsi.Service.EventManager;
import ConsomiTounsi.Service.EventManagerInterface;
import ConsomiTounsi.Service.ProductManagerInterface;
import ConsomiTounsi.entities.Client;
import ConsomiTounsi.entities.Event;
import ConsomiTounsi.entities.Pool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventManagerInterface eventmanager ;
    @Autowired
    EventManager manager;


    //@PostMapping("/add")
   //ublic void addEvent(@RequestBody Event e){ eventmanager.addEvent1(e);}


    @PostMapping("/add-id")
    public void addEvent(@RequestBody Event e, @RequestParam("id") long id){ eventmanager.addEvent(e,id);}

    @GetMapping("/retrieve-all")
    public List<Event> getListEvents(){ return eventmanager.retrieveAllEvent(); }
    @PutMapping("/AddClienttoevent/{id}")
    public void addclientstoevent(@PathVariable("id") Long id,@RequestBody List<Client> client){
        manager.addClientToEvent(id,client);
    }

}


