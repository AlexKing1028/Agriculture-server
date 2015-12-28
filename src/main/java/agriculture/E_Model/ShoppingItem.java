package agriculture.E_Model;

import java.sql.Timestamp;

/**
 * Created by redrock on 15/12/28.
 */
public class ShoppingItem {
    long uid;
    CommodityItem commodityItem;
    int count;

    public ShoppingItem(long uid, CommodityItem commodityItem, int count, Timestamp timestamp) {
        this.uid = uid;
        this.commodityItem = commodityItem;
        this.count = count;
        this.timestamp = timestamp;
    }

    public int getCount() {
        return count;
    }

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
}
