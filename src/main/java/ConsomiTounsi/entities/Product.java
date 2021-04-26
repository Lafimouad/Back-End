package ConsomiTounsi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantity;
	private boolean productofthemonth;
	private String code;
	private String name;
	private String category;
	private double price;
	private float rating;
	private typeShelf shelf;
	private boolean available;
	private String description;
	private double weight;
	private String imagePath ;
	@ManyToOne
	Supplier supplier;

	@OneToOne
	private Feedback feedback;
	@JsonIgnore
	@ManyToMany(mappedBy="products",cascade= CascadeType.PERSIST,fetch = FetchType.EAGER)

	private List<Order> orders;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Shelf> R_product;
	
	@ManyToOne
	Stock stock;
}
