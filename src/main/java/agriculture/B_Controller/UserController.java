package agriculture.B_Controller;

import agriculture.A_ViewModel.ViewUserDetail;
import agriculture.C_Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.ResponseWrapper;

/**
 * Created by redrock on 15/12/16.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public ViewUserDetail register(@RequestParam String username, @RequestParam String password) {
        /*
        ViewUserDetail user = userService.createNewUser(username, password);
        if (user != null) {
            return user;
        }
        throw new DuplicateKeyException("username duplicated");
        */
        return null;
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(){
        return "web login is not supported";
    }

    @RequestMapping(path = "/check_allowance", method = RequestMethod.GET)
    public String checkAllowance(@RequestParam String username) {
        String result = userService.checkUserAllowance(username);
        if (result == null) {
            return "allowed";
        }
        return "not allowed";
    }
}
