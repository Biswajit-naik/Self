package comt.est_server.testserver.service.impl;

import comt.est_server.testserver.models.Product;
import comt.est_server.testserver.models.User;
import comt.est_server.testserver.repositorys.UserRepository;
import comt.est_server.testserver.service.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserActionsHandler implements UserAction {

    public UserRepository userRepository;
    private RestTemplate restTemplate;

    // Constructor injection
    @Autowired
    UserActionsHandler(UserRepository userrepo,RestTemplate restTemplate){
        this.userRepository = userrepo;
        this.restTemplate = restTemplate;
    }
    @Override
    public void createuser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateuser() {

    }

    @Override
    public void deleteuser(String email) {
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


    @Override
    public void login() {

    }
}
