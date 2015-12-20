package agriculture.D_DAO;

import agriculture.E_Model.UserDetail;

/**
 * Created by redrock on 15/12/20.
 */
public interface UserDetailDao {
    boolean addUserDetail(UserDetail userDetail);
    boolean updateUserDetail(UserDetail userDetail);
    UserDetail selectWith(String username);
}
