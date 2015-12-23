package agriculture.C_Service;

import agriculture.D_DAO.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by redrock on 15/12/17.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> gas = new ArrayList<>();
        gas.add(new SimpleGrantedAuthority("USER"));
        agriculture.E_Model.User user = userDao.findUserByUserName(username);
        UserDetails userDetails = new User(user.getName(), user.getPassword(),true, true, true, true, gas);
        return userDetails;
    }
}
