package ConsomiTounsi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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


	@ManyToMany(mappedBy="R_product", cascade = CascadeType.ALL)
	private Set<Product> product;

}
