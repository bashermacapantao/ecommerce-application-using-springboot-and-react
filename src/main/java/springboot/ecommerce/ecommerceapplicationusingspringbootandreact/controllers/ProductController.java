package springboot.ecommerce.ecommerceapplicationusingspringbootandreact.controllers;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.ecommerce.ecommerceapplicationusingspringbootandreact.models.Product;
import springboot.ecommerce.ecommerceapplicationusingspringbootandreact.services.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController // annotation is used to mark the class as a REST controller.
@RequestMapping("/products") // sets the base URL for all endpoints defined in this controller.
public class ProductController {
    private final ProductService productService;

    // @Autowired // is used to inject the ProductService dependency into the controller.
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Get/products - Get all products
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    
    // GET /products/{id} - Get product by ID
    @GetMapping("/{id}")
    //ResponseEntity is used to customize the HTTP response status and body.
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok().body(product);
    }

    // POST /products - Create a new product
    @PostMapping
    //@RequestBody - annotation is used to bind the request body to a method parameter.
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    // PUT /products/{id} - Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok().body(updatedProduct);
    }

    // DELETE /products/{id} - Delete a product
    @DeleteMapping("/{id}")
    //@PathVariable annotation is used to bind the placeholder in the URL to a method parameter.
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
