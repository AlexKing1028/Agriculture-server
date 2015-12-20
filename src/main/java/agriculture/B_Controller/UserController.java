package agriculture.B_Controller;

import agriculture.A_ViewModel.INFO;
import agriculture.A_ViewModel.ViewUserDetail;
import agriculture.C_Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * Created by redrock on 15/12/16.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public ResponseEntity register(@RequestParam String username, @RequestParam String password) {
        ViewUserDetail user = userService.createNewUser(username, password);
        if (user != null) {
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.setLocation(URI.create(user.getLink().getHerf()));
            responseHeader.set("Content-Location", user.getLink().getHerf());
            responseHeader.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(user, responseHeader, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("creation failure.",HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/check_allowence", method = RequestMethod.GET)
    public ResponseEntity<String> checkAllowence(@RequestParam String username) {
        String result = userService.checkUserAllowance(username);
        if (result == null) {
            return new ResponseEntity<>("user name allowed", HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.CONFLICT);
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public INFO login(@RequestParam String username, @RequestParam String password) {
        if (userService.findUserByUserName("tmp") == null) {
            return new INFO("no user");
        }
        return new INFO("user not found");
    }
}
