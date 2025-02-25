package comt.est_server.testserver.service.impl;

import comt.est_server.testserver.exception.ResourceNotFoundException;
import comt.est_server.testserver.models.CustomUserDetail;
import comt.est_server.testserver.repositorys.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import comt.est_server.testserver.models.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//implements UserDetailsService
/*
    we are using Custom Authenticationprovider with manually implementation ,show we not require to implements UserDetailsService,
    because it only use by defaultProvider (DaoAuthenticationProvider) , their it require  to load username .


    if we trying to use implemnted UserDeatilsService Interface  with CustomAuthenticationProvider it shohing error like:

    2025-02-24T23:24:47.287+05:30  WARN 38263 --- [testserver] [           main] r$InitializeUserDetailsManagerConfigurer : Global AuthenticationManager configured with an AuthenticationProvider bean. UserDetailsService beans will not be used by Spring Security for automatically configuring username/password login. Consider removing the AuthenticationProvider bean. Alternatively, consider using the UserDetailsService in a manually instantiated DaoAuthenticationProvider. If the current configuration is intentional, to turn off this warning, increase the logging level of 'org.springframework.security.config.annotation.authentication.configuration.InitializeUserDetailsBeanManagerConfigurer' to ERROR

 */
@Service
@Lazy
public class CustomUserDetailService {

    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepo){
        System.out.println("INtalizing Custom UserDeatils Service ----------------");
        this.userRepository = userRepo;
    }

//    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("username not found"));
        return new CustomUserDetail(user);
    }
}
