package agriculture.DA_DaoImp;

import agriculture.DA_DaoImp.RowMapper.ShoppingItemRowMapper;
import agriculture.D_DAO.ShoppingCartDao;
import agriculture.E_Model.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by redrock on 15/12/28.
 */
@Repository
public class ShoppingCartDaoImp extends BaseDaoImp implements ShoppingCartDao {
    @Autowired
    private ShoppingItemRowMapper shoppingItemRowMapper;

    @Override
    public void add(int cid, int uid) {
        String query = "insert into shopcart (uid, cid) values(?,?)";
        getJdbcTemplate().update(query, uid, cid);
    }

    @Override
    public void delete(int cid, int uid) {
        String query = "delete from shopcart where uid=? and cid=?";
        getJdbcTemplate().update(query, uid, cid);
    }

    @Override
    public List<ShoppingItem> find(int uid) {
        String query = "select uid, cid, cname, imageurl, briefinfo,timestamp from shopcart as s join commodities as c on s.cid=c.cid where uid = ?";
        List<ShoppingItem> result=getJdbcTemplate().query(query, shoppingItemRowMapper, uid);
        return result;
    }
}
