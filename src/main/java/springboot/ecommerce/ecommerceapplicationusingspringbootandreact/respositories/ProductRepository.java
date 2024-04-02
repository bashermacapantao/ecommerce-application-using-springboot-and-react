package springboot.ecommerce.ecommerceapplicationusingspringbootandreact.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.ecommerce.ecommerceapplicationusingspringbootandreact.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Custom query method to find products by name
    List<Product> findByProductName(String productName);

    List<Product> findByProductPriceLessThan(Double productPrice);

    List<Product> findByProductPriceGreaterThan(Double productPrice);
    
}
