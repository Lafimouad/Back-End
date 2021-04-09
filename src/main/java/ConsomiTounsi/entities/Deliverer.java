package ConsomiTounsi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.Set;

@Entity
public class Deliverer extends User implements Serializable {
	
	public Deliverer(boolean delivererOfTheMonthDeliverer, boolean availableDeliverer, double distanceDeliverer,
			double bonusDeliverer, int scoreDeliverer) {
		super(); 
		this.delivererOfTheMonthDeliverer = delivererOfTheMonthDeliverer;
		this.availableDeliverer = availableDeliverer;
		this.distanceDeliverer = distanceDeliverer;
		this.bonusDeliverer = bonusDeliverer;
		this.scoreDeliverer = scoreDeliverer;
	}

	public Deliverer() {
		super();
		// TODO Auto-generated constructor stub
	}

	private boolean delivererOfTheMonthDeliverer;
	
	@Column(columnDefinition = "boolean default true")
	private boolean availableDeliverer;
	
	private double distanceDeliverer;
	
	private double bonusDeliverer;
	
	private int scoreDeliverer; 

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
	
	public int getScoreDeliverer() {
		return scoreDeliverer;
	}

	public void setScoreDeliverer(int scoreDeliverer) {
		this.scoreDeliverer = scoreDeliverer;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="deliverer")
	private Set<Delivery> delivery;
}
