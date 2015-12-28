package agriculture.A_ViewModel;

import java.sql.Timestamp;

/**
 * Created by redrock on 15/12/28.
 */
public class ViewShoppingItem {
    ViewCommodityBreifInfo commodityBreifInfo;
    int count;
    Timestamp timestamp;

    public ViewShoppingItem(ViewCommodityBreifInfo commodityBreifInfo, int count, Timestamp timestamp) {
        this.commodityBreifInfo = commodityBreifInfo;
        this.count = count;
        this.timestamp = timestamp;
    }
}

