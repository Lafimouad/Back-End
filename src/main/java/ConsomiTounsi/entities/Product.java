package ConsomiTounsi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id_product;
	
	private int quantity_product;
	private String code_product;
	private int rating_product;
	private String name_product;
	private String category_product;
	private double price_product;
	private String shelf_product;
	private boolean available_product;
	private String description_product;
	private double weight_product;

	@ManyToOne
	Supplier supplier;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private Set<Feedback> feedback;
	@JsonIgnore
	@ManyToOne
	private Order order;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Shelf> R_product;
	
	@ManyToOne
	Stock stock;

	public void setOrder(Order optionalorder) {
		// TODO Auto-generated method stub
		
	}
}
