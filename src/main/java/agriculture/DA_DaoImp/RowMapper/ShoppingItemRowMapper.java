package agriculture.DA_DaoImp.RowMapper;

import agriculture.E_Model.CommodityItem;
import agriculture.E_Model.ShoppingItem;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by redrock on 15/12/28.
 */
@Repository
public class ShoppingItemRowMapper implements RowMapper<ShoppingItem>{
    @Override
    public ShoppingItem mapRow(ResultSet rs, int rowNum) throws SQLException {

        int uid=rs.getInt(1);
        int cid=rs.getInt(2);
        String cname=rs.getString(3);
        String imageurl=rs.getString(4);
        String briefinfo=rs.getString(5);
        Timestamp timestamp=rs.getTimestamp(6);
        CommodityItem commodityItem=new CommodityItem(cid,cname,briefinfo,imageurl);
        return new ShoppingItem(uid, commodityItem, timestamp);
    }
}
