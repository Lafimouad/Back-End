package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Message implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_message;
	private String test_message;
	
	@Temporal (TemporalType.DATE)
	private Date date_message;


	public int getId_message() {
		return id_message;
	}

	public void setId_message(int id_message) {
		this.id_message = id_message;
	}

	public String getTest_message() {
		return test_message;
	}

	public void setTest_message(String test_message) {
		this.test_message = test_message;
	}

	public Date getDate_message() {
		return date_message;
	}

	public void setDate_message(Date date_message) {
		this.date_message = date_message;
	}

}
