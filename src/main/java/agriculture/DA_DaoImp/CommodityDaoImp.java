package agriculture.DA_DaoImp;

import agriculture.DA_DaoImp.RowMapper.CommodityItemRowMapper;
import agriculture.D_DAO.CommodityDao;
import agriculture.E_Model.CommodityItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

/**
 * Created by redrock on 15/12/23.
 */
public class CommodityDaoImp extends BaseDaoImp implements CommodityDao {
    @Autowired
    private CommodityItemRowMapper commodityItemRowMapper;

    @Override
    public Iterator<CommodityItem> pagination(int start, int size) {
        String query = "select cid, cname, manufacturer, imageurl from commodities limit ?, ?";
        List<CommodityItem> result = getJdbcTemplate().query(query, commodityItemRowMapper, start, start+size);
        return result==null? null:result.iterator();
    }
}
