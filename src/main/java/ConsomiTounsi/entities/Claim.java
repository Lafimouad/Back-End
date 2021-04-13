package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;


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
	private int ProductWithProb ;


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


	public int getLevel() {
		return Level;
	}


	public void setLevel(int level) {
		Level = level;
	}



	public int getProductWithProb() {
		return ProductWithProb;
	}


	public void setProductWithProb(int productWithProb) {
		ProductWithProb = productWithProb;
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