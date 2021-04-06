package ConsomiTounsi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Donation implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_donation;

	@ManyToOne
	Event event;
}
