package agriculture.DA_DaoImp;

import agriculture.D_DAO.UserDao;
import agriculture.E_Model.User;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by redrock on 15/12/16.
 */

@Repository
public class UserDaoImp implements UserDao{

    @Override
    public User findUserByUserName(String username) {
        if ("tmp".equals(username)){
            return new User("tmp","tmpps");
        }

        return null;
    }

    @Override
    public User createUser(String username, String password) {

        return null;
    }
}
