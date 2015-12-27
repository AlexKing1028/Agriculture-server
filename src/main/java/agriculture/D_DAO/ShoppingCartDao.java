package agriculture.D_DAO;

import agriculture.E_Model.ShoppingItem;

import java.util.List;

/**
 * Created by redrock on 15/12/28.
 */
public interface ShoppingCartDao {
    void add(int cid, int uid);
    void delete(int cid, int uid);
    List<ShoppingItem> find(int uid);
}
