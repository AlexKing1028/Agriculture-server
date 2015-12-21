package agriculture.DA_DaoImp.RowMapper;

import agriculture.E_Model.UserDetail;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by redrock on 15/12/21.
 */
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
