package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Delivery implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id_delivery;
	
	@Temporal (TemporalType.DATE)
	private Date date_delivery;
	
	private String destination_delivery;
	
	@Enumerated(EnumType.STRING)
	private QualityOfDelivering quality_delivery;
	
	private String service_delivery;
	
	@Enumerated(EnumType.STRING)
	private DurationOfDelivering duration_delivery;
	
	@Enumerated(EnumType.STRING)
	private MeansOfTransport meanOfTransport_delivery;
	private double cost_delivery;
	private int scoreDelivery;

	public long getId_delivery() {
		return id_delivery;
	}

	public void setId_delivery(long id_delivery) {
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

	public String getService_delivery() {
		return service_delivery;
	}
	public void setService_delivery(String service_delivery) {
		this.service_delivery = service_delivery; 
	}
	public DurationOfDelivering getDuration_delivery() {
		return duration_delivery;
	}

	public void setDuration_delivery(DurationOfDelivering duration_delivery) {
		this.duration_delivery = duration_delivery;
	}
	public QualityOfDelivering getQuality_delivery() {
		return quality_delivery;
	}

	public void setQuality_delivery(QualityOfDelivering quality_delivery) {
		this.quality_delivery = quality_delivery;
	}
	public int getScoreDelivery() {
		return scoreDelivery;
	}

	public void setScoreDelivery(int scoreDelivery) {
		this.scoreDelivery = scoreDelivery;
	}
	
	@ManyToOne
	Deliverer deliverer;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="delivery")
	private Set<Order> order;
}
