package agriculture.C_Service;

import agriculture.D_DAO.ShoppingCartDao;
import agriculture.E_Model.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by redrock on 15/12/28.
 */
@Service
public class ShopCartService {
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    public void addShoppingItem(int uid, int cid){
        shoppingCartDao.add(cid, uid);
    }

    public void deleteShoppingItem(int uid, int cid){
        shoppingCartDao.delete(cid, uid);
    }

    public List fetchAllRecord(int uid){
        List<ShoppingItem> items=shoppingCartDao.find(uid);

        return null;
    }
}
