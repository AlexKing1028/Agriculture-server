package agriculture.DA_DaoImp.RowMapper;

import agriculture.E_Model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by redrock on 15/12/22.
 */
@Repository
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        String username=rs.getString(1);
        String password=rs.getString(2);
        return new User(username, password);
    }
}
