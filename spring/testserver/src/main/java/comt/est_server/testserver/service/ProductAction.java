package comt.est_server.testserver.service;

import comt.est_server.testserver.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductAction {
    List<Product> getallproducts();
}
