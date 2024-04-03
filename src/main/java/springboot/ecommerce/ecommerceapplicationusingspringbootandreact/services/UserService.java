package springboot.ecommerce.ecommerceapplicationusingspringbootandreact.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import springboot.ecommerce.ecommerceapplicationusingspringbootandreact.models.User;
import springboot.ecommerce.ecommerceapplicationusingspringbootandreact.respositories.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id:" + id));
    }

    public User  creatUser (User user){
        return userRepository.save(user);
    }

    public User updatUser (Long id, User user){
        User existingUser = getUserById(id);
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    public void deleteUser (Long id){
        User existingUser = getUserById(id);
        userRepository.delete(existingUser);
    }

    
}
