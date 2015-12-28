package agriculture.E_Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by redrock on 15/12/20.
 */
public class CustomUserDetails extends User {
    long uid;
    String phone;
    String email;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, long uid, String phone, String email) {
        super(username, password, authorities);
        this.uid = uid;
        this.phone = phone;
        this.email = email;
    }

    public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, long uid, String phone, String email) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.uid = uid;
        this.phone = phone;
        this.email = email;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
