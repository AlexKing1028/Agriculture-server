package agriculture.C_Service;

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
public class UserDetailServiceImpl implements UserDetailsService{
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> gas=new ArrayList<>();
        gas.add(new SimpleGrantedAuthority("USER"));
        UserDetails userDetails=new User(username, "12345", true, true, true, true, gas);
        return userDetails;
    }

}
