package comt.est_server.testserver.controllers;

import comt.est_server.testserver.models.Product;
import comt.est_server.testserver.models.Signup;
import comt.est_server.testserver.models.User;
import comt.est_server.testserver.service.ProductAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import comt.est_server.testserver.service.UserAction;

import java.util.List;

@RestController
@RequestMapping("/v1/")
public class UserController {

    @Autowired
    public UserAction useraction;
    @Autowired
    public ProductAction productAction;

    @PostMapping(value = "/signup")
    public ResponseEntity<?> signupuser(@RequestBody Signup userform){
        System.out.println("signup details:"+ userform.toString());
        try{
            if (userform == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            //check password
            if (!userform.getPassword().equals(userform.getConfirmpassword())){
                throw new RuntimeException("invalid password");
            }

            User user = new User();
            user.setUsername(userform.getFirstname()+userform.getLastname());
            user.setEmail(userform.getEmail());
            user.setPhonenumber(userform.getPhonenumber());
            user.setPassword(userform.getPassword());

            useraction.createuser(user);
        } catch (RuntimeException e) {
            return  ResponseEntity
                    .status(401)
                    .body("signup failed "+e);
        }
        return ResponseEntity
                .status(200)
                .body("signup successfull");
    }


    @GetMapping(value = "/getproducts")
    public ResponseEntity<?> getallproducts(){
         List<Product> productList = productAction.getallproducts();
        return ResponseEntity
                .status(200)
                .body(productList);
    }
}
