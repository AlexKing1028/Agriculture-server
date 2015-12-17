package agriculture.B_Controller;

import agriculture.E_Model.Item;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by REDROCK on 12/9/2015.
 */

@RestController
@RequestMapping("/")
public class InfoController{
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
}
