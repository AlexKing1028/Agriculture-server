package agriculture.B_Controller;

import agriculture.E_Model.CustomUserDetails;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by redrock on 15/12/28.
 */
public abstract class AuthenticatedController {
    CustomUserDetails customUserDetails;

    public CustomUserDetails getCustomUserDetails() throws AuthenticationException {
        if (customUserDetails == null) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof CustomUserDetails) {
                customUserDetails=(CustomUserDetails)principal;
            }else {
                throw new AuthenticationCredentialsNotFoundException("you need to login again");
            }
        }
        return customUserDetails;
    }
}
