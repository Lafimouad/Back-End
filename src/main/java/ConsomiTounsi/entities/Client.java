package ConsomiTounsi.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.Set;

@Entity

public class Client extends User implements Serializable {

	public Client() {
		super();
	}

	
	
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

	
	
	
	
	
    @ManyToOne
    Message message;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Advertisement> advertisement;

}
