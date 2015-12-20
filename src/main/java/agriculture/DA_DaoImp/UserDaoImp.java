package agriculture.DA_DaoImp;

import agriculture.D_DAO.UserDao;
import agriculture.E_Model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by redrock on 15/12/16.
 */

@Repository
public class UserDaoImp extends BaseDaoImp implements UserDao {

    @Override
    public User findUserByUserName(String username) {
        if ("tmp".equals(username)) {
            return new User("tmp", "tmpps");
        }

        return null;
    }

    @Override
    public boolean isUserExists(String username) {
        String query = "select * from users where username=?";
        List<String> result = getJdbcTemplate().query(query, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return null;
            }
        }, username);
        if (result != null || result.size() != 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean createUser(String username, String password) {
        String query = "insert into users values(?,?,?)";
        int result = getJdbcTemplate().update(query, username, password, true);
        return result >= 1;
    }
}
