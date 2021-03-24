package ConsomiTounsi.entities;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Deliverer extends User implements Serializable {
	
	public Deliverer(boolean delivererOfTheMonthDeliverer, boolean availableDeliverer, double distanceDeliverer,
			double bonusDeliverer) {
		super();
		this.delivererOfTheMonthDeliverer = delivererOfTheMonthDeliverer;
		this.availableDeliverer = availableDeliverer;
		this.distanceDeliverer = distanceDeliverer;
		this.bonusDeliverer = bonusDeliverer;
	}

	public Deliverer() {
		super();
		// TODO Auto-generated constructor stub
	}

	private boolean delivererOfTheMonthDeliverer;
	
	private boolean availableDeliverer;
	
	private double distanceDeliverer;
	
	private double bonusDeliverer;

	public boolean isDelivererOfTheMonthDeliverer() {
		return delivererOfTheMonthDeliverer;
	}

	public void setDelivererOfTheMonthDeliverer(boolean delivererOfTheMonthDeliverer) {
		this.delivererOfTheMonthDeliverer = delivererOfTheMonthDeliverer;
	}

	public boolean isAvailableDeliverer() {
		return availableDeliverer;
	}

	public void setAvailableDeliverer(boolean availableDeliverer) {
		this.availableDeliverer = availableDeliverer;
	}

	public double getDistanceDeliverer() {
		return distanceDeliverer;
	}

	public void setDistanceDeliverer(double distanceDeliverer) {
		this.distanceDeliverer = distanceDeliverer;
	}

	public double getBonusDeliverer() {
		return bonusDeliverer;
	}

	public void setBonusDeliverer(double bonusDeliverer) {
		this.bonusDeliverer = bonusDeliverer;
	}

}
