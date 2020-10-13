package restsparketl.health.entity;

/**
 * @author:wxb
 * @description:
 * @date:15:162019/11/20
 */
public class LoginUser {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginUser() {
    }

    public void setPassword(String password) {
        this.password = password;
    }



    private String password;


}
