package agriculture.C_Service;

import agriculture.A_ViewModel.ViewUserDetail;
import agriculture.D_DAO.UserDao;
import agriculture.D_DAO.UserDetailDao;
import agriculture.E_Model.CustomUserDetails;
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


    /*
    public ViewUserDetail createNewUser(String name, String password) {
        String pass = passwordEncoder.encode(password);
        if (!userDao.createUser(name, pass)) {
            return null;
        }
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUsername(name);
        if (!userDetailDao.addUserDetail(customUserDetails)) {
            return null;
        }
        customUserDetails = userDetailDao.selectWith(name);
        if (customUserDetails != null) {
            return new ViewUserDetail(customUserDetails.getUserid(), customUserDetails.getUsername(), customUserDetails.getPhone(), customUserDetails.getEmail());
        } else {
            return null;
        }
    }
    */

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
