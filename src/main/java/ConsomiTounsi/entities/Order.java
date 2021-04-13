package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="\"Order\"")

public class Order implements Serializable {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_order;
	@Temporal (TemporalType.DATE)
	private Date date_order;
	
	@Enumerated(EnumType.STRING)
	private Payment paymentType_order;
	
	private float cost_order;
	private boolean paid_order;
	private float weight_order;

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}

	public Date getDate_order() {
		return date_order;
	}

	public void setDate_order(Date date_order) {
		this.date_order = date_order;
	}

	public Payment getPaymentType_order() {
		return paymentType_order;
	}

	public void setPaymentType_order(Payment paymentType_order) {
		this.paymentType_order = paymentType_order;
	}

	public float getCost_order() {
		return cost_order;
	}

	public void setCost_order(float cost_order) {
		this.cost_order = cost_order;
	}

	public boolean isPaid_order() {
		return paid_order;
	}

	public void setPaid_order(boolean paid_order) {
		this.paid_order = paid_order;
	}

	public float getWeight_order() {
		return weight_order;
	}

	public void setWeight_order(float weight_order) {
		this.weight_order = weight_order;
	}

	@ManyToOne
	Delivery delivery;

	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)

	private List<Product> products;

	public boolean addproduct(Product p) {
		if(products == null)
			products = new ArrayList<>();

		return products.add(p);
	}
}
