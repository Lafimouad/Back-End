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
	private String code;
	private float rating;
	private String name;
	private String category;
	private double price;

	private String shelf;
	private boolean available;
	private String description;
	private double weight;

	@ManyToOne
	Supplier supplier;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private Set<Feedback> feedback;
	@ManyToMany(cascade= CascadeType.ALL)
	private List<Order> orders;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Shelf> R_product;
	
	@ManyToOne
	Stock stock;

	public void setOrder(Order optionalorder) {
		// TODO Auto-generated method stub
		
	}
}
