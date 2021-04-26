package ConsomiTounsi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
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
	private long id_product;
	
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

	@JsonIgnore
	@ManyToMany(mappedBy="products",cascade= CascadeType.PERSIST,fetch = FetchType.EAGER)

	private List<Order> orders;


	@ManyToOne
	private Shelf shelf;

	public boolean addorders(Order o) {
		if(orders == null)
			orders = new ArrayList<>();

		return orders.add(o);
	}
}
