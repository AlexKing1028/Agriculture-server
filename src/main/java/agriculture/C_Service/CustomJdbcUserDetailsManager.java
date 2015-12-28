package agriculture.C_Service;

import agriculture.E_Model.CustomUserDetails;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.List;

/**
 * Created by redrock on 15/12/28.
 */
public class CustomJdbcUserDetailsManager extends JdbcUserDetailsManager {
    final String userdetails_query = "select userid, d.username, password, enabled, phone, email from userdetails as d join users as u on d.username=u.username where u.username=?";

    @Override
    protected List<UserDetails> loadUsersByUsername(String username) {
        return getJdbcTemplate().query(userdetails_query, (rs, rowNum) -> {
            return new CustomUserDetails(rs.getString(2), rs.getString(3), rs.getBoolean(4), true, true, true, AuthorityUtils.NO_AUTHORITIES, rs.getLong(1), rs.getString(5), rs.getString(6));
        }, username);
    }
}
