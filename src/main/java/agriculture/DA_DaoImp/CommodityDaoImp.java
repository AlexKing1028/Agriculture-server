package agriculture.DA_DaoImp;

import agriculture.DA_DaoImp.RowMapper.CommodityItemRowMapper;
import agriculture.DA_DaoImp.RowMapper.CommodityRowMapper;
import agriculture.D_DAO.CommodityDao;
import agriculture.E_Model.Commodity;
import agriculture.E_Model.CommodityItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by redrock on 15/12/23.
 */
@Repository
public class CommodityDaoImp extends BaseDaoImp implements CommodityDao {
    @Autowired
    private CommodityItemRowMapper commodityItemRowMapper;

    @Autowired
    private CommodityRowMapper commodityRowMapper;

    @Override
    public List pagination(int start, int size, RowMapper rowMapper) {
        if (rowMapper == null){
            return pagination(start, size);
        }
        String query = "select cid, cname, imageurl, briefInfo from commodities  limit ?, ?";
        List result = getJdbcTemplate().query(query, rowMapper, start, size);
        return result;
    }

    @Override
    public Commodity getCommodity(int cid) {
        String query = "select c.cid, cname, imageurl, briefinfo, detailinfo, mid, mname, mintroduction from commodities as c left join commoditydetails as d on c.cid=d.cid left join manufacturer as m on c.manufacturer=m.mid where c.cid = ?";

        List<Commodity> result=getJdbcTemplate().query(query, commodityRowMapper, cid);
        if (result != null && result.size()==1){
            return result.get(0);
        }
        return null;
    }

    @Override
    public void insertInDetail(CommodityItem commodityItem, String detailinfo) {
        insert(commodityItem);
        String query = "select cid from commodities where cname=?";
        List<Integer> result=getJdbcTemplate().query(query, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt(1);
            }
        }, commodityItem.getCname());
        if (result != null && result.size()==1){
            String insertion="insert into commoditydetails (cid, detailInfo) values(?, ?)";
            getJdbcTemplate().update(insertion, result.get(0), detailinfo);
        }
    }

    @Override
    public void insert(CommodityItem commodityItem) {
        String query= "insert into commodities (cname, imageurl, briefinfo) values(?, ?, ?)";
        getJdbcTemplate().update(query, commodityItem.getCname(), commodityItem.getImageUrl(), commodityItem.getBriefinfo());
    }

    @Override
    public List<CommodityItem> pagination(int start, int size) {
        String query = "select cid, cname, imageurl, briefInfo from commodities limit ?, ?";
        List<CommodityItem> result = getJdbcTemplate().query(query, commodityItemRowMapper, start, size);
        return result;
    }
}
