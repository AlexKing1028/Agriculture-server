package agriculture.DA_DaoImp;

import agriculture.DA_DaoImp.RowMapper.StringRowMapper;
import agriculture.DA_DaoImp.RowMapper.UserRowMapper;
import agriculture.D_DAO.UserDao;
import agriculture.E_Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by redrock on 15/12/16.
 */

@Repository
public class UserDaoImp extends BaseDaoImp implements UserDao {
    @Autowired
    private StringRowMapper stringRowMapper;
    @Autowired
    private UserRowMapper userRowMapper;

    @Override
    public User findUserByUserName(String username) {
        String query = "select * from users where username = ?";
        List<User> result = getJdbcTemplate().query(query, userRowMapper, username);
        if (result != null && result.size()==1){
            return result.get(0);
        }
        return null;
    }

    @Override
    public boolean checkPassword(String username, String password){
        String query = "select username from users where username=? and password=?";
        List<String> result = getJdbcTemplate().query(query, stringRowMapper,username, password);
        if (result != null && result.size() == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean isUserExists(String username) {
        String query = "select * from users where username=?";
        List<String> result = getJdbcTemplate().query(query, stringRowMapper, username);
        if (result != null || result.size() != 1) {
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
