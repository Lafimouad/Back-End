package ConsomiTounsi.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Stock extends User implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_stock;
	
	private boolean status_stock;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Product> product;
}
