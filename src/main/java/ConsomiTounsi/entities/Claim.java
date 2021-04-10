package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity

public class Claim implements Serializable {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	
	private Long idClaim;
	
	
	private String decision;
	
	

	
	private String date;
	
	private String status;

	private String description;
	private int Level;
	
	@Enumerated(EnumType.STRING)
	private SystemProb systemProb ;
	
	@Enumerated(EnumType.STRING)
	private DeliveryProb deliveryProb ;
	
	@Enumerated(EnumType.STRING)
	private ProductProb ProductProb ;
	
	@Enumerated(EnumType.STRING)
	private ClaimType subject;

	

	public Long getIdClaim() {
		return idClaim;
	}



	public void setIdClaim(Long idClaim) {
		this.idClaim = idClaim;
	}



	public String getDecision() {
		return decision;
	}



	public void setDecision(String decision) {
		this.decision = decision;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public ClaimType getSubject() {
		return subject;
	}



	public void setSubject(ClaimType subject) {
		this.subject = subject;
	}



	public int getLevel() {
		return Level;
	}



	public void setLevel(int level) {
		Level = level;
	}



	public SystemProb getSystemProb() {
		return systemProb;
	}



	public void setSystemProb(SystemProb systemProb) {
		this.systemProb = systemProb;
	}



	public DeliveryProb getDeliveryProb() {
		return deliveryProb;
	}



	public void setDeliveryProb(DeliveryProb deliveryProb) {
		this.deliveryProb = deliveryProb;
	}



	public ProductProb getProductProb() {
		return ProductProb;
	}



	public void setProductProb(ProductProb productProb) {
		ProductProb = productProb;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@ManyToOne
	User user;
	
}

