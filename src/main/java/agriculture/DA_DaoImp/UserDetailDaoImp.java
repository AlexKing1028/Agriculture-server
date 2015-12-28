package agriculture.DA_DaoImp;

import agriculture.DA_DaoImp.RowMapper.UserDetailRowMapper;
import agriculture.D_DAO.UserDetailDao;
import agriculture.E_Model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by redrock on 15/12/20.
 */
@Repository
public class UserDetailDaoImp extends BaseDaoImp implements UserDetailDao {
    @Autowired
    UserDetailRowMapper userDetailRowMapper;

    @Override
    public boolean addUserDetail(CustomUserDetails customUserDetails) {
        if (customUserDetails == null) {
            return false;
        }
        String query = "insert into userdetails (username, phone, email) values(?,?,?)";
        int result = getJdbcTemplate().update(query, customUserDetails.getUsername(), customUserDetails.getPhone(), customUserDetails.getEmail());
        return result >= 0;
    }

    @Override
    public boolean updateUserDetail(CustomUserDetails customUserDetails) {
        return false;
    }

    @Override
    public CustomUserDetails selectWith(String username) {
        String query = "select userid, username, password,phone, email from userdetails as d join user as u on d.username=u.username where u.username=?";
        List<CustomUserDetails> result = getJdbcTemplate().query(query, userDetailRowMapper, username);
        if (result == null || result.size() != 1) {
            return null;
        }
        return result.get(0);
    }

}
