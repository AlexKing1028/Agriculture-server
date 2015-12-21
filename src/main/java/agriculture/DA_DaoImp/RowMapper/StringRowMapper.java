package agriculture.DA_DaoImp.RowMapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by redrock on 15/12/21.
 */
@Repository
public class StringRowMapper implements RowMapper<String>{
    @Override
    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString(0);
    }
}
