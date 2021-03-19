package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Event implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_event;
	
	private double raisedAmount_event;
	private String place_event;
	private String target_event;

	public int getId_event() {
		return id_event;
	}

	public void setId_event(int id_event) {
		this.id_event = id_event;
	}

	public double getRaisedAmount_event() {
		return raisedAmount_event;
	}

	public void setRaisedAmount_event(double raisedAmount_event) {
		this.raisedAmount_event = raisedAmount_event;
	}

	public String getPlace_event() {
		return place_event;
	}

	public void setPlace_event(String place_event) {
		this.place_event = place_event;
	}

	public String getTarget_event() {
		return target_event;
	}

	public void setTarget_event(String target_event) {
		this.target_event = target_event;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy="event")
	private Set<Donation> donation;
	
	@ManyToOne
	Pool pool;
}
