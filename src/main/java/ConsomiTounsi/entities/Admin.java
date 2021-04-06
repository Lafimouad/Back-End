package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Admin extends User implements Serializable {

	@Enumerated(EnumType.STRING)
	private Role role_admin;

	public Role getRole_admin() {
		return role_admin;
	}

	public void setRole_admin(Role role_admin) {
		this.role_admin = role_admin;
	}

	/*@OneToMany(cascade = CascadeType.ALL, mappedBy="admin")
	private Set<Advertisement> advertisement; */

	@ManyToOne
	Message message;
}
