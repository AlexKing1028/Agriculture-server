package agriculture.E_Model;

/**
 * Created by redrock on 15/12/16.
 */

public class User extends BaseModel{

    String name;
    String password;

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
