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
	
	
	@Temporal (TemporalType.DATE)
	
	private Date date;
	
	private String status;

	private String description;
	
	
	private String subject;

	

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



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
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



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
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

