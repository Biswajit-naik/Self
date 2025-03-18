package comt.est_server.testserver.service.impl;

import comt.est_server.testserver.exception.ResourceNotFoundException;
import comt.est_server.testserver.models.User;
import comt.est_server.testserver.repositorys.UserRepository;
import comt.est_server.testserver.service.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserActionsHandler implements UserAction {


    public UserRepository userRepository;
//    private RestTemplate restTemplate;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Constructor injection

    public UserActionsHandler(UserRepository userrepo,RestTemplate restTemplate){
        this.userRepository = userrepo;
//        this.restTemplate = restTemplate;
    }
    /*
       Two roles ADMIN | SIMPLE
       WE CAN SECURE ENDPOINT ACCORDING THAT
     */
    @Override
    public void createuser(User user) {
        String encodepassword = passwordEncoder.encode(user.getPassword());
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        User curruser = new User();
        String userId = UUID.randomUUID().toString();
        curruser.setId(userId);
        curruser.setUsername(user.getUsername());
        curruser.setPassword(encodepassword); // need to update
        curruser.setEmail(user.getEmail());
        curruser.setPhonenumber(user.getPhonenumber());
        curruser.setRole(user.getRole());

        // If the email doesn't exist, save the new user
        if (!existingUser.isPresent()) {
            userRepository.save(curruser);
        } else {
            // Optionally, throw an exception or handle the case where the email already exists
            throw new RuntimeException("Email already exists");
        }
    }

    @Override
    public void updateuser(User user) {


    }

    @Override
    public void deleteuser(String email) {
           User user= userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));
            userRepository.delete(user);
    }

/*    @Override
    Thirdparty call for external url
    public List<Product> getproducts(){
        String URL = "https://fakestoreapi.com/products";
        ResponseEntity<List<Product>> response = restTemplate.getForEntity(URL, List.class);
        System.out.println("Response from product api => " +response.getBody());
        return response.getBody();
    }
 */
}
