package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_user;
	private String username_user;
	private String password_user;
	private String phoneNumber_user;
	private String emailAddress_user;
	@Temporal (TemporalType.DATE)
	private Date dateBirth_user;
	private String address_user;

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getUsername_user() {
		return username_user;
	}

	public void setUsername_user(String username_user) {
		this.username_user = username_user;
	}

	public String getPassword_user() {
		return password_user;
	}

	public void setPassword_user(String password_user) {
		this.password_user = password_user;
	}

	public String getPhoneNumber_user() {
		return phoneNumber_user;
	}

	public void setPhoneNumber_user(String phoneNumber_user) {
		this.phoneNumber_user = phoneNumber_user;
	}

	public String getEmailAddress_user() {
		return emailAddress_user;
	}

	public void setEmailAddress_user(String emailAddress_user) {
		this.emailAddress_user = emailAddress_user;
	}

	public Date getDateBirth_user() {
		return dateBirth_user;
	}

	public void setDateBirth_user(Date dateBirth_user) {
		this.dateBirth_user = dateBirth_user;
	}

	public String getAddress_user() {
		return address_user;
	}

	public void setAddress_user(String address_user) {
		this.address_user = address_user;
	}
}
