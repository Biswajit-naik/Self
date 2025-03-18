package comt.est_server.testserver.controllers;

import comt.est_server.testserver.DTO.SigninRequest;
import comt.est_server.testserver.DTO.SigninResponse;
import comt.est_server.testserver.DTO.SignupRequest;
import comt.est_server.testserver.models.*;
import comt.est_server.testserver.service.ProductAction;
import comt.est_server.testserver.service.UserAction;
import comt.est_server.testserver.service.impl.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    public UserAction useraction;
    @Autowired
    public ProductAction productAction;

    @Autowired
    public JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/login")
    public ResponseEntity<?> signin(@RequestBody SigninRequest user){
        logger.debug("invoke signin method with signin parameter :"+ user.toString());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );


        if (authentication.isAuthenticated()){
            //genrate token
            String token = jwtService.genratetoken(user.getUsername(),true);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + token);

            SigninResponse response = new SigninResponse("Sucess",token, "Login successful");

            SecurityContextHolder.getContext().setAuthentication(authentication);

            return  ResponseEntity.ok()
                    .headers(headers)
                    .body(response);

        }else{

            SigninResponse response = new SigninResponse("failure", null, "Login failed");

            return  ResponseEntity
                     .status(401)
                    .body(response);

        }

    }


    @PostMapping(value = "/signup")
    public ResponseEntity<?> signupuser(@RequestBody SignupRequest userform){
        logger.debug("invoke signup method with userdetail:"+ userform.toString());
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




    @DeleteMapping(value = "/delete-user/{username}")
    public void deleteuser(@PathVariable String username){
        useraction.deleteuser(username);
    }

    @GetMapping(value = "/getproducts")
    public ResponseEntity<?> getallproducts(){
        logger.debug("invoke getAllProducts method ");
         List<Product> productList = productAction.getallproducts();

        return ResponseEntity
                .status(200)
                .body(productList);
    }
}
