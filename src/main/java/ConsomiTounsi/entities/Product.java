package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
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

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}

	

	public String getCode_product() {
		return code_product;
	}

	public void setCode_product(String code_product) {
		this.code_product = code_product;
	}

	public int getRating_product() {
		return rating_product;
	}

	public void setRating_product(int rating_product) {
		this.rating_product = rating_product;
	}

	public String getName_product() {
		return name_product;
	}

	public void setName_product(String name_product) {
		this.name_product = name_product;
	}

	public String getCategory_product() {
		return category_product;
	}

	public void setCategory_product(String category_product) {
		this.category_product = category_product;
	}

	public double getPrice_product() {
		return price_product;
	}

	public void setPrice_product(double price_product) {
		this.price_product = price_product;
	}

	public String getShelf_product() {
		return shelf_product;
	}

	public void setShelf_product(String shelf_product) {
		this.shelf_product = shelf_product;
	}

	public boolean isAvailable_product() {
		return available_product;
	}

	public void setAvailable_product(boolean available_product) {
		this.available_product = available_product;
	}

	public String getDescription_product() {
		return description_product;
	}

	public void setDescription_product(String description_product) {
		this.description_product = description_product;
	}

	public double getWeight_product() {
		return weight_product;
	}

	public void setWeight_product(double weight_product) {
		this.weight_product = weight_product;
	}

	@ManyToOne
	Supplier supplier;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private List<Feedback> feedback;

	@ManyToMany(mappedBy="Cart", cascade = CascadeType.ALL)
	private List<Order> order;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Shelf> R_product;
	
	@ManyToOne
	Stock stock;
}
