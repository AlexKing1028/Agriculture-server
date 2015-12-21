package agriculture.DA_DaoImp;

import agriculture.DA_DaoImp.RowMapper.UserDetailRowMapper;
import agriculture.D_DAO.UserDetailDao;
import agriculture.E_Model.UserDetail;
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
    public boolean addUserDetail(UserDetail userDetail) {
        if (userDetail == null) {
            return false;
        }
        String query = "insert into userdetails (username, phone, email) values(?,?,?)";
        int result = getJdbcTemplate().update(query, userDetail.getUsername(), userDetail.getPhone(), userDetail.getEmail());
        return result >= 0;
    }

    @Override
    public boolean updateUserDetail(UserDetail userDetail) {
        return false;
    }

    @Override
    public UserDetail selectWith(String username) {
        String query = "select * from userdetails where username=?";
        List<UserDetail> result = getJdbcTemplate().query(query, userDetailRowMapper, username);
        if (result == null || result.size() != 1) {
            return null;
        }
        return result.get(0);
    }

}
