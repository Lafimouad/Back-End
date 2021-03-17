package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Donation implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_donation;

	public int getId_donation() {
		return id_donation;
	}

	public void setId_donation(int id_donation) {
		this.id_donation = id_donation;
	}
}
