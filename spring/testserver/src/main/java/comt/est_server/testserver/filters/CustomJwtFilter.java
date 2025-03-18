package comt.est_server.testserver.filters;

//
import comt.est_server.testserver.models.CustomUserDetail;
import comt.est_server.testserver.service.impl.CustomUserDetailService;
import comt.est_server.testserver.service.impl.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/*
    JwtFilter Class is Customfilter where we provide the businessloguc validate the token
 */
@Component
public class CustomJwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private CustomUserDetailService customUserDetailService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring(7).trim();

            if (jwtService.validateToken(token)){
                 String usernameFortoken  = jwtService.getUsernameFromToken(token);

                 /*
                    username means whatever take at login time
                    username = email
                  */

                UserDetails user = customUserDetailService.loadUserByUsername(usernameFortoken);

                if (SecurityContextHolder.getContext().getAuthentication() == null){

                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }



            }

        }
        filterChain.doFilter(request, response);
    }
}

