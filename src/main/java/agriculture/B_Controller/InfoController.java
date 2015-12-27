package agriculture.B_Controller;

import agriculture.A_ViewModel.Link;
import agriculture.A_ViewModel.TypeInfoBaseModel;
import agriculture.A_ViewModel.ViewCommodityBreifInfo;
import agriculture.C_Service.CommodityService;
import agriculture.E_Model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by REDROCK on 12/9/2015.
 */

@RestController
@RequestMapping("/")
public class InfoController{
    @Autowired
    private CommodityService commodityService;

    @RequestMapping("/info")
    public ArrayList<Item> info(){
        ArrayList<Item> result=new ArrayList<>();
        Random random=new Random();
        int start=random.nextInt();
        int footstep=random.nextInt();
        for (int i=0;i<30;i++){
            int tmp=random.nextInt() % 5;
            if (tmp <3) {
                Item.SimpleItem simpleItem = new Item.SimpleItem("title" + start + " then" + i * footstep, "info" + i * footstep);
                result.add(simpleItem);
            }else if (tmp == 3){
                Item.BreifPictureItem breifPictureItem=
                        new Item.BreifPictureItem("title"+start+ " then"+i*footstep, "info"+i*footstep, "http://192.168.1.120:8080/cat.jpg");
                result.add(breifPictureItem);
            }else {
                Item.BreifPictureItem breifPictureItem=
                        new Item.BreifPictureItem("title"+start+ " then"+i*footstep, "info"+i*footstep, "http://192.168.1.120:8080/dog.jpg");
                result.add(breifPictureItem);
            }

        }
        return result;
    }

    @RequestMapping("/curinfo")
    public  List<Object> info(@RequestParam(defaultValue = "0") int start, @RequestParam(defaultValue = "20") int size){
        List<ViewCommodityBreifInfo> image_infos=commodityService.fetchCommodityPagination(start, size);
        ArrayList<Object> result = new ArrayList<>();
        result.addAll(image_infos);
        result.add(new Link("next", "/curinfo?start="+(start+size)+"&size="+size));
        return result;
    }
}
