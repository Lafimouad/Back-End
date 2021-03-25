package ConsomiTounsi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private Long id_order;
	@Temporal (TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date_order;
	
	@Enumerated(EnumType.STRING)
	private Payment_type paymentType_order;
	
	private float cost_order;
	private boolean paid_order;
	private float weight_order;
    private Long id_user;


	@ManyToOne
	Delivery delivery;
	@OneToMany(mappedBy="order")
	private List<Product> products;

}
