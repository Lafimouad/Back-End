package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity

public class Claim implements Serializable {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="id_claim")
	private int id;
	
	@Column(name="desicion_claim")
	private String decision;
	
	
	@Temporal (TemporalType.DATE)
	@Column(name="date_claim")
	private Date date;
	
	private String status;

	private String description;
	
	@Column(name="subject_claim")
	private String subject;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String description() {
		return description;
	}

	public void setDatefinal_claim(String description) {
		this.description = description;
	}

	public String getSubject_claim() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne
	User user;
	
}

