package comt.est_server.testserver.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SigninResponse {
    private String status;
    private String token;
    private String message;
}
