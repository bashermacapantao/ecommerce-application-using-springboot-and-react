package springboot.ecommerce.ecommerceapplicationusingspringbootandreact.services;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import springboot.ecommerce.ecommerceapplicationusingspringbootandreact.models.Product;
import springboot.ecommerce.ecommerceapplicationusingspringbootandreact.respositories.ProductRepository;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    // @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }

    public Product createProduct (Product product){
        return productRepository.save(product);
    }

    public Product updateProduct (Long id, Product product){
        Product existingProduct = getProductById(id);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setProductPrice(product.getProductPrice());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct (Long id){
        Product existingProduct = getProductById(id);
        productRepository.delete(existingProduct);
    }
}
