package agriculture.DA_DaoImp.RowMapper;

import agriculture.E_Model.Commodity;
import agriculture.E_Model.Manufacturer;
import org.hamcrest.text.IsEmptyString;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by redrock on 15/12/27.
 */
@Repository
public class CommodityRowMapper implements RowMapper<Commodity>{
    @Override
    public Commodity mapRow(ResultSet rs, int rowNum) throws SQLException {
        int cid=rs.getInt(1);
        String cname=rs.getString(2);
        String imageurl=rs.getString(3);
        String briefinfo=rs.getString(4);
        String detailinfo = rs.getString(5);
        Integer mid=rs.getInt(6);
        String mname=rs.getString(7);
        String mintroduction=rs.getString(8);
        Manufacturer manufacturer=null;
        if (mid != 0 && mname != null) {
            manufacturer = new Manufacturer(mid, mname, mintroduction);
        }
        Commodity c=new Commodity(cid, cname,imageurl, briefinfo, detailinfo, manufacturer);
        return c;
    }
}
