package pl.edu.pw.pik.pikactivitytrackerserver.DTO;

import javax.validation.constraints.*;

public class UserDto {

    @NotNull
    @NotEmpty
    private String login;

    @NotNull
    @NotEmpty
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // standard getters and setters
}
