package ConsomiTounsi.controllers;

import ConsomiTounsi.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {

    public GetAllProductResponse(List<Product> p) {
		// TODO Auto-generated constructor stub
	}

	List<Product> products;
}
