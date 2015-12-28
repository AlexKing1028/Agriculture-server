package agriculture.DA_DaoImp.RowMapper;

import agriculture.E_Model.CustomUserDetails;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by redrock on 15/12/21.
 */
@Repository
public class UserDetailRowMapper implements RowMapper<CustomUserDetails> {
    @Override
    public CustomUserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomUserDetails customUserDetails = new CustomUserDetails(rs.getString(2),rs.getString(3), null, rs.getLong(1), rs.getString(4), rs.getString(5));
        return customUserDetails;
    }
}
