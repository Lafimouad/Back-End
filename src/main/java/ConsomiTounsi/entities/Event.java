package ConsomiTounsi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_event;
	
	private double raisedAmount_event;
	private String place_event;
	private String target_event;
	@Temporal (TemporalType.DATE)
	private Date date_event;


	@OneToMany(cascade = CascadeType.ALL, mappedBy="event")
	private Set<Donation> donation;
	
	@ManyToOne
	Pool pool;
}
