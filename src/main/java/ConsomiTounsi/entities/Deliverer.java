package ConsomiTounsi.entities;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Deliverer extends User implements Serializable {
	
	private boolean delivererOfTheMonth_deliverer;
	private boolean available_deliverer;
	private double distance_deliverer;
	private double bonnus_deliverer;


	public boolean isDelivererOfTheMonth_deliverer() {
		return delivererOfTheMonth_deliverer;
	}

	public void setDelivererOfTheMonth_deliverer(boolean delivererOfTheMonth_deliverer) {
		this.delivererOfTheMonth_deliverer = delivererOfTheMonth_deliverer;
	}

	public boolean isAvailable_deliverer() {
		return available_deliverer;
	}

	public void setAvailable_deliverer(boolean available_deliverer) {
		this.available_deliverer = available_deliverer;
	}

	public double getDistance_deliverer() {
		return distance_deliverer;
	}

	public void setDistance_deliverer(double distance_deliverer) {
		this.distance_deliverer = distance_deliverer;
	}

	public double getBonnus_deliverer() {
		return bonnus_deliverer;
	}

	public void setBonnus_deliverer(double bonnus_deliverer) {
		this.bonnus_deliverer = bonnus_deliverer;
	}
}
