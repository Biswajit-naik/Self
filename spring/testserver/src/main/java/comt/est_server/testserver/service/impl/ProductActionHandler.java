package comt.est_server.testserver.service.impl;

import comt.est_server.testserver.models.Product;
import comt.est_server.testserver.repositorys.ProductRepository;
import comt.est_server.testserver.service.ProductAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductActionHandler implements ProductAction{

    public  ProductRepository productRepository;


    @Autowired
    ProductActionHandler(ProductRepository productRepo){
     this.productRepository=productRepo;
    }

    @Override
//    @Cacheable("Products")
    public List<Product> getallproducts() {
            List<Product> productList = productRepository.findAll();
            return productList;
    }
}


