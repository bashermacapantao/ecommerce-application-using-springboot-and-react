package springboot.ecommerce.ecommerceapplicationusingspringbootandreact.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.ecommerce.ecommerceapplicationusingspringbootandreact.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    List<User> findByUserName(String userName);
}
