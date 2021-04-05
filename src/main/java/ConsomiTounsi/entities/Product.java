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
public class Product implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_product;
	
	private String code_product;
	private int rating_product;
	private String name_product;
	private String category_product;
	private double price_product;
	private String shelf_product;
	private boolean available_product;
	private String description_product;
	private double weight_product;
	private long quantityProduct;


	@ManyToOne
	Supplier supplier;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private List<Feedback> feedback;

	@ManyToMany(mappedBy="Cart", cascade = CascadeType.ALL)
	private List<Order> order;


	@ManyToOne
	private Shelf shelf;
}
