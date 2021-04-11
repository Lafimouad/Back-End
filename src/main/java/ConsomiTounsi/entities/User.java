package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
	

	public User(long idUser, String firstNameUser, String lastNameUser, String usernameUser, String passwordUser,
			String phoneNumberUser, String emailAddressUser, Date dateBirthUser, String addressUser) {
		super();
		this.idUser = idUser;
		this.firstNameUser = firstNameUser;
		this.lastNameUser = lastNameUser;
		this.usernameUser = usernameUser;
		this.passwordUser = passwordUser;
		this.phoneNumberUser = phoneNumberUser;
		this.emailAddressUser = emailAddressUser;
		this.dateBirthUser = dateBirthUser;
		this.addressUser = addressUser;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long idUser;
	
	private String firstNameUser; 
	
	private String lastNameUser;
	
	@Column(unique=true)
	private String usernameUser;
	
	private String passwordUser;
	
	private String phoneNumberUser;
	
	@Column(unique=true)
	private String emailAddressUser;
	
	@Temporal (TemporalType.DATE)
	private Date dateBirthUser;
	
	private String addressUser;

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsernameUser() {
		return usernameUser;
	}

	public void setUsernameUser(String usernameUser) {
		this.usernameUser = usernameUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public String getPhoneNumberUser() {
		return phoneNumberUser;
	}

	public void setPhoneNumberUser(String phoneNumberUser) {
		this.phoneNumberUser = phoneNumberUser;
	}

	public Date getDateBirthUser() {
		return dateBirthUser;
	}

	public void setDateBirthUser(Date dateBirthUser) {
		this.dateBirthUser = dateBirthUser;
	}

	public String getAddressUser() {
		return addressUser;
	}

	public void setAddressUser(String addressUser) {
		this.addressUser = addressUser;
	}

	public String getEmailAddressUser() {
		return emailAddressUser;
	}

	public void setEmailAddressUser(String emailAddressUser) {
		this.emailAddressUser = emailAddressUser;
	}

	public String getFirstNameUser() {
		return firstNameUser;
	}

	public void setFirstNameUser(String firstNameUser) {
		this.firstNameUser = firstNameUser;
	}

	public String getLastNameUser() {
		return lastNameUser;
	}

	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}

	/*@ManyToOne
	Store store;*/

	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Subject> subject;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Claim> claim;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Pool> pool;

}
