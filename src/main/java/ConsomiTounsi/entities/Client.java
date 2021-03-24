package ConsomiTounsi.entities;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity

public class Client extends User implements Serializable {

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

    @ManyToOne
    Message message;

}
