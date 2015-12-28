package agriculture.D_DAO;

/**
 * Created by redrock on 15/12/16.
 */
public interface UserDao {
    boolean createUser(String username, String password);

    boolean isUserExists(String username);
    boolean checkPassword(String username, String password);
}
