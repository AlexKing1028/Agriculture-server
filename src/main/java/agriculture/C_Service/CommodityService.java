package agriculture.C_Service;

import agriculture.A_ViewModel.ViewCommodityBreifInfo;
import agriculture.A_ViewModel.ViewCommodityDetail;
import agriculture.A_ViewModel.ViewManufacturerInfo;
import agriculture.D_DAO.CommodityDao;
import agriculture.E_Model.Commodity;
import agriculture.E_Model.CommodityItem;
import agriculture.E_Model.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by redrock on 15/12/24.
 */
@Service
public class CommodityService {
    @Autowired
    private CommodityDao commodityDao;

    public List<ViewCommodityBreifInfo> fetchCommodityPagination(int start, int size) {
        List<CommodityItem> items = commodityDao.pagination(start, size);
        if (items == null) {
            return null;
        }
        List<ViewCommodityBreifInfo> infos = new ArrayList<>();
        for (CommodityItem item : items) {
            infos.add(new ViewCommodityBreifInfo(item.getCid(), item.getCname(), item.getBriefinfo(), item.getImageUrl()));
        }
        return infos;
    }

    public ViewCommodityDetail fetchCommodityDetailInfo(int cid) throws Exception {
        Commodity commodity = commodityDao.getCommodity(cid);
        if (commodity == null) {
            throw new Exception();
        }
        ViewManufacturerInfo manufacturerInfo = null;
        if (commodity.getManufacturer() != null) {
            Manufacturer m=commodity.getManufacturer();
            manufacturerInfo = new ViewManufacturerInfo(m.getMid(), m.getMname(),m.getIntroduction());
        }
        ViewCommodityDetail detailinfo=new ViewCommodityDetail(commodity.getCid(), commodity.getCname(), commodity.getImageUrl(), commodity.getBriefinfo(), commodity.getDetailInfo(), manufacturerInfo);
        return detailinfo;
    }
}
