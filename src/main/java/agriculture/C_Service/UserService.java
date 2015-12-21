package agriculture.C_Service;

import agriculture.A_ViewModel.ViewUserDetail;
import agriculture.D_DAO.UserDao;
import agriculture.D_DAO.UserDetailDao;
import agriculture.E_Model.UserDetail;
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

    @Autowired
    private UserDetailDao userDetailDao;

    public boolean checkUser(String username, String password) {
        return userDao.checkPassword(username, password);
    }

    public ViewUserDetail createNewUser(String name, String password) {
        String pass = passwordEncoder.encode(password);
        if (!userDao.createUser(name, pass)) {
            return null;
        }
        UserDetail userDetail = new UserDetail();
        userDetail.setUsername(name);
        if (!userDetailDao.addUserDetail(userDetail)) {
            return null;
        }
        userDetail = userDetailDao.selectWith(name);
        if (userDetail != null) {
            return new ViewUserDetail(userDetail.getUserid(), userDetail.getUsername(), userDetail.getPhone(), userDetail.getEmail());
        } else {
            return null;
        }
    }

    public ViewUserDetail getUserDetail(String name) {
        UserDetail detail = userDetailDao.selectWith(name);
        return new ViewUserDetail(detail.getUserid(), detail.getUsername(), detail.getPhone(), detail.getEmail());
    }

    public String checkUserAllowance(String username) {
        if (username == null || username.equals("")) {
            return "user name empty";
        }
        /**
         * todo ... other checking
         */
        if (userDao.isUserExists(username)) {
            return "user name duplicated";
        }
        return null;
    }
}
