package agriculture.D_DAO;

import agriculture.E_Model.CustomUserDetails;

/**
 * Created by redrock on 15/12/20.
 */
public interface UserDetailDao {
    boolean addUserDetail(CustomUserDetails customUserDetails);
    boolean updateUserDetail(CustomUserDetails customUserDetails);
    CustomUserDetails selectWith(String username);
}
