package ConsomiTounsi.entities;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity

public class Client extends User implements Serializable {

	public Client() {
		super();
	}

	private LocalDateTime subscriptionDate;
	private String subMonth;
	@Enumerated(EnumType.STRING)
	private Gender genderClient;

	@Enumerated(EnumType.STRING)
	private WorkField workfieldClient;

	public WorkField getWorkfieldClient() {
		return workfieldClient;
	}

	public void setWorkfieldClient(WorkField workfieldClient) {
		this.workfieldClient = workfieldClient;
	}

	public Gender getGenderClient() {
		return genderClient;
	}

	public void setGenderClient(Gender genderClient) {
		this.genderClient = genderClient;
	}

	public String getSubMonth() {
		return subMonth;
	}

	public void setSubMonth(String subMonth) {
		this.subMonth = subMonth;
	}

	public void setSubscriptionDate(LocalDateTime subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public LocalDateTime getSubscriptionDate() {
		return subscriptionDate;
	}

	@ManyToOne
    Message message;

}
