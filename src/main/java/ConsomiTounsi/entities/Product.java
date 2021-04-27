package ConsomiTounsi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)

	private Long id;
	private long quantityProduct;
	private boolean productofthemonth;
	private String code;
	private String name;
	private String category;
	private double price;
	private float rating;
	private boolean available;
	private String description;
	private double weight;
	private String imagePath ;

	@Enumerated(EnumType.STRING)
	private TypeCategory categoryProduct;


	@JsonIgnore
	@ManyToMany(mappedBy="products",cascade= CascadeType.PERSIST,fetch = FetchType.EAGER)
	private List<Order> orders;


	@ManyToOne
	private Shelf shelf;

	@ManyToOne
	Supplier supplier;

	@OneToOne
	private Feedback feedback;
}

