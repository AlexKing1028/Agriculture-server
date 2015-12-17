package agriculture.B_Controller;

import agriculture.A_ViewModel.INFO;
import agriculture.C_Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by redrock on 15/12/16.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register", method = RequestMethod.POST, params = "username, password")
    public INFO register(@RequestParam("username") String username, @RequestParam("password") String password){
        if (userService.isUserExisted(username)){
            return new INFO("user not created");
        };
        if (userService.createNewUser(username, password)!=null){
            return new INFO("user created");
        }
        return new INFO("failed to create");
    }


    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public INFO login(){
        if(userService.findUserByUserName("tmp")==null){
            return new INFO("no user");
        };
        return new INFO("user not found");
    }
}
