package ConsomiTounsi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Message implements Serializable {

	@EmbeddedId
	private MessagePK messagePk = new MessagePK();

	private String textMessage;

	@Temporal(TemporalType.DATE)
	private Date dateMessage;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("idClient")
	@JoinColumn(name ="ClientId" , nullable = false , insertable = false , updatable = false)
	private Client client;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("idAdmin")
	@JoinColumn(name ="AdminId" , nullable = false , insertable = false , updatable = false)
	private Admin admin;

	public Message(String textMessage, Date dateMessage, Client client, Admin admin) {
		super();
		this.textMessage = textMessage;
		this.dateMessage = dateMessage;
		this.client = client;
		this.admin = admin;
	}
}
