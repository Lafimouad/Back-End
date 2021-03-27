package ConsomiTounsi.entities;


import javax.persistence.Entity;
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
