package agriculture.B_Controller;

import agriculture.A_ViewModel.ViewCommodityDetail;
import agriculture.C_Service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by redrock on 15/12/27.
 */
@RestController
@RequestMapping("/")
public class DetailController {
    @Autowired
    private CommodityService commodityService;

    @RequestMapping("/commodity/{cid}")
    public ViewCommodityDetail commodityDetailIntroduction(@PathVariable int cid) throws Exception{
        ViewCommodityDetail detail=commodityService.fetchCommodityDetailInfo(cid);
        return detail;
    }
}
