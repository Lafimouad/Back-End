package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Shelf implements Serializable {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_shelf;
	
	@Enumerated(EnumType.STRING)
    private typeShelf type_shelf;

	public int getId_shelf() {
		return id_shelf;
	}

	public void setId_shelf(int id_shelf) {
		this.id_shelf = id_shelf;
	}

	public typeShelf getType_shelf() {
		return type_shelf;
	}

	public void setType_shelf(typeShelf type_shelf) {
		this.type_shelf = type_shelf;
	}

	@ManyToOne
	Store store;

	@ManyToMany(mappedBy="association2", cascade = CascadeType.ALL)
	private Set<Product> product;
}
