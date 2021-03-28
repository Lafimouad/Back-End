package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Set;

@Entity
public class Pool implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_pool;

	public int getId_pool() {
		return id_pool;
	}

	public void setId_pool(int id_pool) {
		this.id_pool = id_pool;
	}

	public double getAmount_pool() {
		return amount_pool;
	}

	public void setAmount_pool(double amount_pool) {
		this.amount_pool = amount_pool;
	}

	private double amount_pool;

	@ManyToOne
	User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="pool")
	private Set<Event> event;



}
