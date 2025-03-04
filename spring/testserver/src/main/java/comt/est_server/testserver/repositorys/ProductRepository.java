package comt.est_server.testserver.repositorys;

import comt.est_server.testserver.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Optional<Product> findBytitle(String s);
}
