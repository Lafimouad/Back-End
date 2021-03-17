package ConsomiTounsi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Store implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_store;
	private String name_store;
	private String address_store;
	private boolean open_store;
	private double gain_store;

	public int getId_store() {
		return id_store;
	}

	public void setId_store(int id_store) {
		this.id_store = id_store;
	}

	public String getName_store() {
		return name_store;
	}

	public void setName_store(String name_store) {
		this.name_store = name_store;
	}

	public String getAddress_store() {
		return address_store;
	}

	public void setAddress_store(String address_store) {
		this.address_store = address_store;
	}

	public boolean isOpen_store() {
		return open_store;
	}

	public void setOpen_store(boolean open_store) {
		this.open_store = open_store;
	}

	public double getGain_store() {
		return gain_store;
	}

	public void setGain_store(double gain_store) {
		this.gain_store = gain_store;
	}
}
