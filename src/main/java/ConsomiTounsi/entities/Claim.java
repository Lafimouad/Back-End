package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity

public class Claim implements Serializable {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_claim;
	
	private String decision_claim;
	
	@Temporal (TemporalType.DATE)
	private Date date_claim;
	
	@Temporal (TemporalType.DATE)
	private Date datefinal_claim;
	
	private String subject_claim;

	public int getId_claim() {
		return id_claim;
	}

	public void setId_claim(int id_claim) {
		this.id_claim = id_claim;
	}

	public String getDecision_claim() {
		return decision_claim;
	}

	public void setDecision_claim(String decision_claim) {
		this.decision_claim = decision_claim;
	}

	public Date getDate_claim() {
		return date_claim;
	}

	public void setDate_claim(Date date_claim) {
		this.date_claim = date_claim;
	}

	public Date getDatefinal_claim() {
		return datefinal_claim;
	}

	public void setDatefinal_claim(Date datefinal_claim) {
		this.datefinal_claim = datefinal_claim;
	}

	public String getSubject_claim() {
		return subject_claim;
	}

	public void setSubject_claim(String subject_claim) {
		this.subject_claim = subject_claim;
	}

	@ManyToOne
	User user;
}
