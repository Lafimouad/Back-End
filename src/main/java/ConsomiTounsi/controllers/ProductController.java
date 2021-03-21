package ConsomiTounsi.controllers;

import ConsomiTounsi.Service.ProductManager;
import ConsomiTounsi.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductManager pm;
    @PostMapping
    ResponseEntity<?> createNewProduct(@RequestBody Product p){

       pm.addProduct(p);
        return new ResponseEntity<>(new TestResponseModel("Product Tesna3"), HttpStatus.CREATED);
    }
    @GetMapping
    ResponseEntity<?> getAllProduct(){
        List<Product> p=pm.retrieveAllProducts();
        GetAllProductResponse products = new GetAllProductResponse(p);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(pm.FindProduct(id),HttpStatus.OK);

    }

    @DeleteMapping ("/{id}")
    ResponseEntity<?> deleteProductById(@PathVariable Long id){
        pm.deleteProduct(id);
        return new ResponseEntity<>(new TestResponseModel("Product Deleted"),HttpStatus.OK);

    }

    @PutMapping
    ResponseEntity<?> updateProduct(@RequestBody Product p){

        pm.updateProduct(p);
        return new ResponseEntity<>(new TestResponseModel("Product 3mal update"), HttpStatus.CREATED);
    }

}
