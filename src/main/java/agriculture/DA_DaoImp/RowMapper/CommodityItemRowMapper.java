package agriculture.DA_DaoImp.RowMapper;

import agriculture.E_Model.CommodityItem;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by redrock on 15/12/24.
 */
@Repository
public class CommodityItemRowMapper implements RowMapper<CommodityItem>{
    @Override
    public CommodityItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        int cid=rs.getInt(1);
        String cname=rs.getString(2);
        String briefinfo=rs.getString(3);
        String imageurl=rs.getString(4);
        return new CommodityItem(cid, cname, briefinfo, imageurl);
    }
}
