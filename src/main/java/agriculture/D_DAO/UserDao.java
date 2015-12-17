package agriculture.D_DAO;

import agriculture.E_Model.User;

/**
 * Created by redrock on 15/12/16.
 */
public interface UserDao {
    User findUserByUserName(String username);

    User createUser(String username, String password);w
}
