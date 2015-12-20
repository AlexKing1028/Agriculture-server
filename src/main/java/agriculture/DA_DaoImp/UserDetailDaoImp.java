package agriculture.DA_DaoImp;

import agriculture.D_DAO.UserDetailDao;
import agriculture.E_Model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        List<UserDetail> result=getJdbcTemplate().query(query, userDetailRowMapper, username);
        if (result == null || result.size() != 1){
            return result.get(0);
        }
        return null;
    }

    @Repository
    public class UserDetailRowMapper implements RowMapper<UserDetail> {
        @Override
        public UserDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserDetail userDetail = new UserDetail();
            userDetail.setUserid(rs.getInt("userid"));
            userDetail.setUsername(rs.getString("username"));
            userDetail.setPhone(rs.getString("phone"));
            userDetail.setEmail(rs.getString("email"));
            return userDetail;
        }
    }
}
