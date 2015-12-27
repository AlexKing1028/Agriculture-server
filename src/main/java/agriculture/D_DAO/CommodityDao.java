package agriculture.D_DAO;

import agriculture.E_Model.Commodity;
import agriculture.E_Model.CommodityItem;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * Created by redrock on 15/12/23.
 */
public interface CommodityDao {
    List<CommodityItem> pagination(int start, int size);

    List  pagination(int start, int size, RowMapper rowMapper);

    void insert(CommodityItem commodityItem);

    void insertInDetail(CommodityItem commodityItem, String detailinfo);

    Commodity getCommodity(int cid);
}
