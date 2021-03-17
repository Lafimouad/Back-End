package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Delivery implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_delivery;
	
	@Temporal (TemporalType.DATE)
	private Date date_delivery;
	
	private String destination_delivery;
	
	@Enumerated(EnumType.STRING)
	private MeansOfTransport meanOfTransport_delivery;
	private double cost_delivery;

	public int getId_delivery() {
		return id_delivery;
	}

	public void setId_delivery(int id_delivery) {
		this.id_delivery = id_delivery;
	}

	public Date getDate_delivery() {
		return date_delivery;
	}

	public void setDate_delivery(Date date_delivery) {
		this.date_delivery = date_delivery;
	}

	public String getDestination_delivery() {
		return destination_delivery;
	}

	public void setDestination_delivery(String destination_delivery) {
		this.destination_delivery = destination_delivery;
	}

	public MeansOfTransport getMeanOfTransport_delivery() {
		return meanOfTransport_delivery;
	}

	public void setMeanOfTransport_delivery(MeansOfTransport meanOfTransport_delivery) {
		this.meanOfTransport_delivery = meanOfTransport_delivery;
	}

	public double getCost_delivery() {
		return cost_delivery;
	}

	public void setCost_delivery(double cost_delivery) {
		this.cost_delivery = cost_delivery;
	}
}
