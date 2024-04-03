package springboot.ecommerce.ecommerceapplicationusingspringbootandreact.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.ecommerce.ecommerceapplicationusingspringbootandreact.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
