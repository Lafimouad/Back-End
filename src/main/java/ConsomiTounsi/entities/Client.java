package ConsomiTounsi.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

@Entity

public class Client extends User implements Serializable {

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

    @ManyToOne
    Message message;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Event> event;

}
