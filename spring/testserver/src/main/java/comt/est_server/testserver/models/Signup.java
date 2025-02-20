package comt.est_server.testserver.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Signup {
    String firstname;
    String lastname;
    String email;
    String phonenumber;
    String Password;
    String confirmpassword;
}
