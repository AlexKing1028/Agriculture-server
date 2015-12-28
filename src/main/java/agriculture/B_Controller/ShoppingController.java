package agriculture.B_Controller;

import agriculture.A_ViewModel.ViewShoppingItem;
import agriculture.C_Service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by redrock on 15/12/28.
 */
@RestController
@RequestMapping("/shop")
public class ShoppingController extends AuthenticatedController {
    @Autowired
    private ShopCartService shopCartService;

    @RequestMapping("/add")
    public void addToShoppingCart(@RequestParam int cid) {
        shopCartService.addShoppingItem(getCustomUserDetails().getUid(), cid);
    }

    @RequestMapping("/delete")
    public void deleteShoppingCart(@RequestParam int cid) {
        shopCartService.deleteShoppingItem(getCustomUserDetails().getUid(), cid);
    }

    @RequestMapping("/find")
    public List<ViewShoppingItem> findAllFromShoppingCart() {
        return shopCartService.fetchAllRecord(getCustomUserDetails().getUid());
    }

    @RequestMapping("/update")
    public void updateCount(@RequestParam int cid, @RequestParam int count) {
        if (count <= 0) {
            /**
             * todo... what exception ??
             */
            return;
        }
        shopCartService.updateShoppingItemCount(getCustomUserDetails().getUid(), cid, count);
    }
}
