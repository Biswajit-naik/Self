package comt.est_server.testserver.service;

import comt.est_server.testserver.models.Product;
import comt.est_server.testserver.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserAction {

    void createuser(User user);
    void updateuser();
    void deleteuser(String email);
    void login();

}
