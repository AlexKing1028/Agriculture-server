package agriculture.B_Controller;

import agriculture.A_ViewModel.LinkBaseModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by redrock on 15/12/28.
 */
@RestController
@RequestMapping("/shop")
public class ShoppingController {
    @RequestMapping("/add")
    public void addToShoppingCart(@RequestParam int cid){

    }

    @RequestMapping("/delete")
    public void deleteShoppingCart(@RequestParam int cid){

    }

    @RequestMapping("/find")
    public List<LinkBaseModel> findAllFromShoppingCart(){
        return null;
    }
}
