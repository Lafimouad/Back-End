package ConsomiTounsi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id_event;
	
	private double raisedAmount_event;
	private String place_event;
	private String target_event;
	//@Temporal (TemporalType.DATE)
	private LocalDateTime date_event;
	private int nombreplace;



	@OneToMany(cascade = CascadeType.ALL, mappedBy="event")
	private List<Donation> donation;
	
	/*@ManyToOne
	Pool pool;*/

	/*@ManyToMany(cascade = CascadeType.ALL, mappedBy="event")
	private List<Client> clients;*/

	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(
			name = "client_event",
			joinColumns = @JoinColumn(name = "event_id"),
			inverseJoinColumns = @JoinColumn(name = "client_id"))

	private List<Client> clients;

	public void addclients(List<Client> addedCleints){

		addedCleints.forEach(product -> {

			if (clientsExist(product.getId())){
				throw new IllegalStateException("Product Not Found");
			}
			products.add(product);
		});
	}

	public void addproducts(Product addedProducts){
		if (productExist(addedProducts.getId()))
		{throw new IllegalStateException("Product Not even Found");}
		products.add(addedProducts);

	}
	private  boolean productExist ( Long idProduct ){
		for ( Product product:products   ){
			if ( product.getId()==idProduct)
				return true  ;

		}
		return  false ;
	}






}
