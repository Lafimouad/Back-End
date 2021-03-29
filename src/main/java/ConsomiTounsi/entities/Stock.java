package ConsomiTounsi.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
	private Long id_stock;
	
	private String Stockname;
	
	private boolean status_stock;
	
	private Long Product_quantity;
	
	private  String nameProduct;

	
	public Stock(String stockname, Long product_quantity, String nameProduct) {
		super();
		Stockname = stockname;
		Product_quantity = product_quantity;
		this.nameProduct = nameProduct;
	}


	public Stock(Long id_stock, String stockname, boolean status_stock, Long product_quantity, String nameProduct,
			List<Product> product) {
		super();
		this.id_stock = id_stock;
		Stockname = stockname;
		this.status_stock = status_stock;
		Product_quantity = product_quantity;
		this.nameProduct = nameProduct;
		this.product = product;
	}


	public Long getId_stock() {
		return id_stock;
	}


	public void setId_stock(Long id_stock) {
		this.id_stock = id_stock;
	}

	public String getStockname() {
		return Stockname;
	}




	public void setStockname(String stockname) {
		Stockname = stockname;
	}


	public boolean isStatus_stock() {
		return status_stock;
	}



	public void setStatus_stock(boolean status_stock) {
		this.status_stock = status_stock;
	}



	public Long getProduct_quantity() {
		return Product_quantity;
	}



	@Override
	public String toString() {
		return "Stock [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


	public void setProduct_quantity(Long product_quantity) {
		Product_quantity = product_quantity;
	}




	public String getNameProduct() {
		return nameProduct;
	}



	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}


	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}



	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private List<Product> product;
}
