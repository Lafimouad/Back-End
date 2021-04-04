package ConsomiTounsi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="\"Order\"")

public class Order implements Serializable {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal (TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date;
	
	@Enumerated(EnumType.STRING)
	private Payment_type paymentType;
	
	private float cost;
	private boolean paid;
	private float weight;
    private Long idUser;


	@ManyToOne
	Delivery delivery;

	@ManyToMany(mappedBy="orders", cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)

	private List<Product> products;

	public void addproducts(List<Product> addedProducts){

		addedProducts.forEach(product -> {

			if (!productExist(product.getId()))
				products.add(product);
		});
	}

	public void addproducts(Product addedProducts){
        if (!productExist(addedProducts.getId()))
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
