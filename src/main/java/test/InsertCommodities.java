package test;

import agriculture.Application;
import agriculture.D_DAO.CommodityDao;
import agriculture.E_Model.CommodityItem;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * Created by redrock on 15/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class InsertCommodities {
    final static String detail="One of the coolest new technologies from the Spring Foundation has to be the new Spring Boot project. Spring Boot takes all the common template / bootstrap / setup code that everyone is doing already and just does it for you.\n" +
            "\n" +
            "It also covers all the main Spring technologies: Spring MVC, Spring Batch, Spring Security, etc. Need a database? Just add the schema. Need a service? Just add a request mapping. Spring Boot will interpret your setup and start a server if needed.\n";

    final static int length=detail.length();

    @Rule
    public OutputCapture capture;

    @Autowired
    CommodityDao commodityDao;

    @Test
    public void testInsert(){
        Random random=new Random();
        for (int i=0;i<120;i++){
            String cname="commodity name"+i;
            String imageurl="/image/"+random.nextInt()+".jpg";
            String briefinfo="brief "+ i +"th infomation in the database";
            String detailinfo=detail.substring(random.nextInt(length));
            CommodityItem commodityItem=new CommodityItem(-1, cname, briefinfo, imageurl);
            commodityDao.insertInDetail(commodityItem, detailinfo);
        }
    }
}
