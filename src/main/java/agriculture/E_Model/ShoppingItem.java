package agriculture.E_Model;

import java.sql.Timestamp;

/**
 * Created by redrock on 15/12/28.
 */
public class ShoppingItem {
    long uid;
    CommodityItem commodityItem;
    Timestamp timestamp;

    public long getUid() {
        return uid;
    }

    public CommodityItem getCommodityItem() {
        return commodityItem;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public ShoppingItem(long uid, CommodityItem commodityItem, Timestamp timestamp) {

        this.uid = uid;
        this.commodityItem = commodityItem;
        this.timestamp = timestamp;
    }
}
