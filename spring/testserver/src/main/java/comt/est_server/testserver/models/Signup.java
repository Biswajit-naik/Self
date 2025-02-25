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
    private String firstname;
    private String lastname;
    private String email;
    private RoleSelector role;
    private String phonenumber;
    private String Password;
    private String confirmpassword;
}
