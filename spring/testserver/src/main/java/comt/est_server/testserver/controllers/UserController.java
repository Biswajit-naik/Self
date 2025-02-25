package comt.est_server.testserver.controllers;

import comt.est_server.testserver.models.*;
import comt.est_server.testserver.service.ProductAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import comt.est_server.testserver.service.UserAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/auth")
public class UserController {

    @Autowired
    public UserAction useraction;
    @Autowired
    public ProductAction productAction;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/login")
    public ResponseEntity<?>signin(@RequestBody Signin user){
        System.out.println("request coming to /-login enpoint");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);


        return  ResponseEntity
                .status(200)
                .body("signin sucessfull ");
    }


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
            user.setRole(userform.getRole());


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
        System.out.println(productList);
        return ResponseEntity
                .status(200)
                .body(productList);
    }
}
