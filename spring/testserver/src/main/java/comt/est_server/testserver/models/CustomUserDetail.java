package comt.est_server.testserver.models;
//
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetail implements UserDetails {

    private final User user ;

    public CustomUserDetail(User user){
        this.user = user;
    }
        //add later
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> d = new ArrayList<SimpleGrantedAuthority>();
        d.add(new SimpleGrantedAuthority(String.valueOf(user.getRole())));
        return d;
    }

    /*
        For UserForm Email is the username
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }
}
