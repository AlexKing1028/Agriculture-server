package agriculture.C_Service;

import agriculture.D_DAO.UserDao;
import agriculture.E_Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by redrock on 15/12/16.
 */

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDao;

    public boolean hashMatchUser(String username, String password) {
        User user = userDao.findUserByUserName(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public User findUserByUserName(String username) {
        return userDao.findUserByUserName(username);
    }


    public boolean isUserExisted(String username) {
        return false;
    }

    public User createNewUser(String name, String password){
        String pass=passwordEncoder.encode(password);
        return userDao.createUser(name, pass);
    }
}
