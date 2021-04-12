package ConsomiTounsi.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Client extends User implements Serializable {

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

    @ManyToOne
    Message message;

	/*@ManyToMany(cascade = CascadeType.ALL)
	private List<Event> event;*/

	@JsonIgnore
	@ManyToMany(mappedBy="clients",cascade= CascadeType.PERSIST,fetch = FetchType.EAGER)
	private List<Event> events;

	public boolean addEvent(Event ev) {
		if(events == null)
			events = new ArrayList<>();

		return events.add(ev);
	}

	public boolean removeEvent(Event ev) {
		if(events == null)
			events = new ArrayList<>();

		return events.remove(ev);
	}


}
