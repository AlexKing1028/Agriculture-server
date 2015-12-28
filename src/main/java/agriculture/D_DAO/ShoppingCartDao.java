package agriculture.D_DAO;

import agriculture.E_Model.ShoppingItem;

import java.util.List;

/**
 * Created by redrock on 15/12/28.
 */
public interface ShoppingCartDao {
    void add(int cid, long uid);
    void delete(int cid, long uid);
    List<ShoppingItem> find(long uid);
    void updateCount(long uid, int cid, int count);
}
