package agriculture.D_DAO;

import agriculture.E_Model.CommodityItem;

import java.util.Iterator;

/**
 * Created by redrock on 15/12/23.
 */
public interface CommodityDao{
    Iterator<CommodityItem> pagination(int start, int size);
}
