package comt.est_server.testserver.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "users") // Specify the collection name (optional)
public class User {

    @Id
    private String id;  // In MongoDB, the ID is a string by default
    private String username;
    @Indexed(unique = true)
    private String email;
    private String phonenumber;
    private String password;

}


