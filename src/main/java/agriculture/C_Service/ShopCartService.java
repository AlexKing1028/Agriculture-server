package agriculture.C_Service;

import agriculture.A_ViewModel.ViewCommodityBreifInfo;
import agriculture.A_ViewModel.ViewShoppingItem;
import agriculture.D_DAO.ShoppingCartDao;
import agriculture.E_Model.CommodityItem;
import agriculture.E_Model.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by redrock on 15/12/28.
 */
@Service
public class ShopCartService {
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    public void addShoppingItem(long uid, int cid) {
        shoppingCartDao.add(cid, uid);
    }

    public void deleteShoppingItem(long uid, int cid) {
        shoppingCartDao.delete(cid, uid);
    }

    public List fetchAllRecord(long uid) {
        List<ShoppingItem> items = shoppingCartDao.find(uid);
        List<ViewShoppingItem> result=new ArrayList<>();
        for (ShoppingItem item : items){
            CommodityItem commodityItem=item.getCommodityItem();
            ViewCommodityBreifInfo commodityBreifInfo=new ViewCommodityBreifInfo(commodityItem.getCid(), commodityItem.getCname(), commodityItem.getBriefinfo(), commodityItem.getImageUrl());
            result.add(new ViewShoppingItem(commodityBreifInfo, item.getCount(), item.getTimestamp()));
        }
        return result;
    }

    public void updateShoppingItemCount(long uid, int cid, int count){
        shoppingCartDao.updateCount(uid, cid, count);
    }
}
