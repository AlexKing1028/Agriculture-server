package test;

import agriculture.A_ViewModel.ViewShoppingItem;
import agriculture.Application;
import agriculture.C_Service.ShopCartService;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by redrock on 15/12/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class TestShoppingCart {
    final static String host = "https://127.0.0.1:9000";
    RestTemplate restTemplate = new TestRestTemplate(TestRestTemplate.HttpClientOption.ENABLE_COOKIES);

    @Autowired
    private ShopCartService shopCartService;

    @Before
    public void configSsl() throws Exception {

        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
                new SSLContextBuilder().loadTrustMaterial(null,
                        (chain, authType) -> (true)
                ).build(), new AllowAllHostnameVerifier());
        HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory)
                .build();
        ((HttpComponentsClientHttpRequestFactory) restTemplate.getRequestFactory())
                .setHttpClient(httpClient);
    }


    @Test
    public void testShoppingCart() {
        final long uid = 9;
        final int cid_1 = 20;
        final int cid_2 = 100;
        final int cid_3 = 1;
        shopCartService.addShoppingItem(uid, cid_1);
        shopCartService.addShoppingItem(uid, cid_2);
        shopCartService.addShoppingItem(uid, cid_3);
        shopCartService.updateShoppingItemCount(uid, cid_1, 20);
        shopCartService.deleteShoppingItem(uid, cid_2);
        List<ViewShoppingItem> result = shopCartService.fetchAllRecord(uid);
        assert result.size() == 2;
    }

    /**
     @Test public void testShoppingCart() {
     Map<String, String> urlvariable = new HashMap<>();
     urlvariable.put("username", "swlabcd");
     urlvariable.put("password", "1");
     urlvariable.put("remember-me", "on");
     ResponseEntity<String> entity = restTemplate.postForEntity(
     host + "/Login", String.class, String.class, urlvariable);
     System.out.println(entity.toString());
     HttpHeaders response_headers=entity.getHeaders();
     List<String> setcookies=response_headers.get(HttpHeaders.SET_COOKIE);
     for (String s:setcookies){
     System.out.println(s);
     }
     HttpHeaders request_headers = new HttpHeaders();
     request_headers.set(HttpHeaders.COOKIE, setcookies.get(1));
     HttpEntity entity1 = new HttpEntity(null, request_headers);
     ResponseEntity<String> result = restTemplate.exchange(host + "/info", HttpMethod.GET,entity1, String.class);
     System.out.println(result);
     }
     **/
}
