package ConsomiTounsi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pool implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_pool;
	private double amount_pool;

	@ManyToOne
	User user;
	
	@OneToMany(mappedBy="pool",cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
			fetch= FetchType.EAGER)
	private Set<Event> event;



}
