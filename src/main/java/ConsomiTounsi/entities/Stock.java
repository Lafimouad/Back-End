package ConsomiTounsi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id_stock;
	
	private boolean status_stock;
	
	@OneToMany(mappedBy="stock")
	private List<Product> products;
}
