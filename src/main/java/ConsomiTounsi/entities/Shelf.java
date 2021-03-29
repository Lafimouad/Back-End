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
public class Shelf implements Serializable {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_shelf;
	
	@Enumerated(EnumType.STRING)
    private typeShelf type_shelf;



	@ManyToOne
	Store store;


	@OneToMany(mappedBy="shelf")
	private List<Product> product;

}
