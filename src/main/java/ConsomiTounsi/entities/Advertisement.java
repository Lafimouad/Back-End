package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Advertisement implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_advertisment;
	
	private String name_advertisement;
	
	@Temporal (TemporalType.DATE)
	private Date date_advertisment;
	@Temporal (TemporalType.DATE)
	private Date enddate_advertisement;
	private int finalviews_advertisement;
	private int targetviews_advertisement;
	@Enumerated(EnumType.STRING)
	private TypeAdvertisement type_advertisement;
	private double cost_advertisement;
	private String channel_advertisement;

	public int getId_advertisment() {
		return id_advertisment;
	}

	public void setId_advertisment(int id_advertisment) {
		this.id_advertisment = id_advertisment;
	}

	public String getName_advertisement() {
		return name_advertisement;
	}

	public void setName_advertisement(String name_advertisement) {
		this.name_advertisement = name_advertisement;
	}

	public Date getDate_advertisment() {
		return date_advertisment;
	}

	public void setDate_advertisment(Date date_advertisment) {
		this.date_advertisment = date_advertisment;
	}

	public Date getEnddate_advertisement() {
		return enddate_advertisement;
	}

	public void setEnddate_advertisement(Date enddate_advertisement) {
		this.enddate_advertisement = enddate_advertisement;
	}

	public int getFinalviews_advertisement() {
		return finalviews_advertisement;
	}

	public void setFinalviews_advertisement(int finalviews_advertisement) {
		this.finalviews_advertisement = finalviews_advertisement;
	}

	public int getTargetviews_advertisement() {
		return targetviews_advertisement;
	}

	public void setTargetviews_advertisement(int targetviews_advertisement) {
		this.targetviews_advertisement = targetviews_advertisement;
	}

	public TypeAdvertisement getType_advertisement() {
		return type_advertisement;
	}

	public void setType_advertisement(TypeAdvertisement type_advertisement) {
		this.type_advertisement = type_advertisement;
	}

	public double getCost_advertisement() {
		return cost_advertisement;
	}

	public void setCost_advertisement(double cost_advertisement) {
		this.cost_advertisement = cost_advertisement;
	}

	public String getChannel_advertisement() {
		return channel_advertisement;
	}

	public void setChannel_advertisement(String channel_advertisement) {
		this.channel_advertisement = channel_advertisement;
	}
	@ManyToOne
	Admin admin;

	@ManyToOne
	Message message;

}
