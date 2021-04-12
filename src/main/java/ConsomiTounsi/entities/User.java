package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long idUser;
	private String username_user;
	private String password_user;
	private String phoneNumber_user;
	private String emailAddress_user;
	private LocalDateTime  dateBirth_user;
	private String address_user;
	@Enumerated(EnumType.STRING)
	private Gender genderClient;

	@Enumerated(EnumType.STRING)
	private WorkField workfieldClient;
	
	
	
	
	
	public Gender getGenderClient() {
		return genderClient;
	}

	public void setGenderClient(Gender genderClient) {
		this.genderClient = genderClient;
	}

	public WorkField getWorkfieldClient() {
		return workfieldClient;
	}

	public void setWorkfieldClient(WorkField workfieldClient) {
		this.workfieldClient = workfieldClient;
	}

	

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

	public LocalDateTime getDateBirth_user() {
		return dateBirth_user;
	}

	public void setDateBirth_user(LocalDateTime dateBirth_user) {
		this.dateBirth_user = dateBirth_user;
	}

	public String getAddress_user() {
		return address_user;
	}

	public void setAddress_user(String address_user) {
		this.address_user = address_user;
	}

	@ManyToOne
	Store store;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Subject> subject;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Claim> claim;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Pool> pool;
}
