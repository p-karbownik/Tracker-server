package pl.edu.pw.pik.pikactivitytrackerserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String username;
    private String password;
    private String user_id;
    private String salt;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUser_id() { return user_id; }

    public String getSalt() { return salt; }
}
