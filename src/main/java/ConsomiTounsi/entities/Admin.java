package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Admin extends User implements Serializable {

	public Admin(Role roleAdmin) {
		super();
		this.roleAdmin = roleAdmin;
	}

	public Admin() {
		super();	}

	@Enumerated(EnumType.STRING)
	private Role roleAdmin;

	public Role getRoleAdmin() {
		return roleAdmin;
	}

	public void setRoleAdmin(Role roleAdmin) {
		this.roleAdmin = roleAdmin;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="admin")
	private Set<Advertisement> advertisement;

	@OneToMany(mappedBy = "admin")
	private Set <Message> messages = new HashSet<>();
}
