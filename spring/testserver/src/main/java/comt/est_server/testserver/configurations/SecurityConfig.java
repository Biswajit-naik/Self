package comt.est_server.testserver.configurations;

import comt.est_server.testserver.service.impl.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;

//.requestMatchers("/v1/health").permitAll()


/*
    Bydefault Spring-starter-security automatic configure springsecurty configure class SecurityConfigurerAdapter in spring 6
    before 6 it will work with WebSecurityConfigurerAdapter(spring 5),
    if we work with springframework we manually extend this class & overide the configure & another method.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    @Autowired
//    private  CustomUserDetailService customUserDetailService;


    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception  {
            http.csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/v1/auth/login","/v1/auth/signup").permitAll()
                        .requestMatchers("/v1/**").authenticated()
                            .anyRequest().permitAll()
            )
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }


//    @Bean
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailService)
//                .passwordEncoder(passwordEncoder());
//    }




    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    /*
        DaoAuthenticationProvider is the default authenticationprovider.
        it taking the userdetailservice and passwordencoder ,7 check authentication in this method additionalAuthenticationChecks();


        if we want to configure own authentication business logic then implment authenticationprovider & overide the provided method authentication().

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
         DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
                daoProvider.setUserDetailsService(customUserDetailService);
                daoProvider.setPasswordEncoder(passwordEncoder());
        return daoProvider;
    }

     */

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return  authenticationConfiguration.getAuthenticationManager();
    }


    /*
        Is it for custom in memory Userdatails
     */
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new InMemoryUserDetailsManager(User.withUsername("user")
//                .password(passwordEncoder().encode("password")) // Use the encoder
//                .roles("USER")
//                .build(),
//                User.withUsername("admin")
//                        .password(passwordEncoder().encode("admin")) // Use the encoder
//                        .roles("ADMIN")
//                        .build());
//
//    }
//






}
