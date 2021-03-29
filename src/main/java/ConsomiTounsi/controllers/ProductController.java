package ConsomiTounsi.controllers;

import ConsomiTounsi.Service.ProductManager;
import ConsomiTounsi.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductManager pm;
    @PostMapping("/product")
    ResponseEntity<?> createNewProduct( @RequestBody Product p){

       pm.addProduct(p);
        return new ResponseEntity<>(new MessageResponseModel("Product Added"), HttpStatus.CREATED);
    }
    @GetMapping("/product")
    ResponseEntity<?> getAllProduct(){
        List<Product> p=pm.retrieveAllProducts();
        GetAllProductResponse products = new GetAllProductResponse(p);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    ResponseEntity<?> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(pm.FindProduct(id),HttpStatus.OK);

    }
    @GetMapping("/getproductsbyorder/{id}")
    ResponseEntity<?> getProductByOrder(@PathVariable Long id){
        return new ResponseEntity<>(pm.FindByOrder(id),HttpStatus.OK);
    }
    @DeleteMapping ("/product/{id}")
    ResponseEntity<?> deleteProductById(@PathVariable Long id){
        pm.deleteProduct(id);
        return new ResponseEntity<>(new MessageResponseModel("Product Deleted"),HttpStatus.OK);

    }

    @PutMapping("/product")
    ResponseEntity<?> updateProduct(@RequestBody Product p){

        pm.updateProduct(p);
        return new ResponseEntity<>(new MessageResponseModel("Product Updated"), HttpStatus.CREATED);
    }

}
