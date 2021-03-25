package ConsomiTounsi.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Stock implements Serializable {
	
	/*public static final int ENTRRE =1;
	
	public static final int SORTIE = 2;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateMvt;
	
		private int typeMvt;
		*/
	
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_stock;
	
	private String Stockname;
	
	private boolean status_stock;
	
	private float quantite;
	
	private  String nameProduct;

	
	public Stock(String stockname, float quantite, String nameProduct) {
		super();
		Stockname = stockname;
		this.quantite = quantite;
		this.nameProduct = nameProduct;
	}




	public String getStockname() {
		return Stockname;
	}




	public void setStockname(String stockname) {
		Stockname = stockname;
	}




	public String getNameProduct() {
		return nameProduct;
	}




	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}




	public int getId_stock() {
		return id_stock;
	}




	public void setId_stock(int id_stock) {
		this.id_stock = id_stock;
	}




	public boolean isStatus_stock() {
		return status_stock;
	}




	public void setStatus_stock(boolean status_stock) {
		this.status_stock = status_stock;
	}




	public float getQuantite() {
		return quantite;
	}




	public void setQuantite(float quantite) {
		this.quantite = quantite;
	}





	public Set<Product> getProduct() {
		return product;
	}




	public void setProduct(Set<Product> product) {
		this.product = product;
	}




	
	

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Product> product;
}
