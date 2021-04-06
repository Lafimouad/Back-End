package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Product implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int idProduct;
	
	private int quantityProduct;
	private String codeProduct;
	private int ratingProduct;
	private String nameProduct;
	@Enumerated(EnumType.STRING)
	private TypeCategory categoryProduct;
	private double priceProduct;
	private String shelfProduct;
	private boolean availableProduct;
	private String descriptionProduct;
	private double weightProduct;

	

	

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public String getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(String codeProduct) {
		this.codeProduct = codeProduct;
	}

	public int getRatingProduct() {
		return ratingProduct;
	}

	public void setRatingProduct(int ratingProduct) {
		this.ratingProduct = ratingProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public TypeCategory getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(TypeCategory categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	public double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(double priceProduct) {
		this.priceProduct = priceProduct;
	}

	public String getShelfProduct() {
		return shelfProduct;
	}

	public void setShelfProduct(String shelfProduct) {
		this.shelfProduct = shelfProduct;
	}

	public boolean isAvailableProduct() {
		return availableProduct;
	}

	public void setAvailableProduct(boolean availableProduct) {
		this.availableProduct = availableProduct;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public double getWeightProduct() {
		return weightProduct;
	}

	public void setWeightProduct(double weightProduct) {
		this.weightProduct = weightProduct;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Set<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(Set<Feedback> feedback) {
		this.feedback = feedback;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	public Set<Shelf> getR_product() {
		return R_product;
	}

	public void setR_product(Set<Shelf> r_product) {
		R_product = r_product;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	@ManyToOne
	Supplier supplier;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private Set<Feedback> feedback;

	@ManyToMany(mappedBy="Cart", cascade = CascadeType.ALL)
	private Set<Order> order;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Shelf> R_product;
	
	@ManyToOne
	Stock stock;
}
