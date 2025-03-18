package comt.est_server.testserver.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SigninRequest {
    private String username;
    private  String password;
}
