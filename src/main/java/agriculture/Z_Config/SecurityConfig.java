package agriculture.Z_Config;

import agriculture.C_Service.CustomJdbcUserDetailsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * Created by redrock on 15/12/16.
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcUserDetailsManager userDetailsService = new CustomJdbcUserDetailsManager();
        userDetailsService.setDataSource(dataSource);
        return userDetailsService;
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    @Bean
    public AuthenticationProvider customAuthenticaitonProvider() {
        DaoAuthenticationProvider custom = new DaoAuthenticationProvider();
        custom.setUserDetailsService(userDetailsService());
        custom.setPasswordEncoder(passwordEncoder());
        return custom;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticaitonProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.rememberMe().rememberMeServices(new PersistentTokenBasedRememberMeServices("redrock", userDetailsService(), persistentTokenRepository()));
        http
                .authorizeRequests()
                .antMatchers("/greeting", "/curinfo", "/commodity/**", "/user/login", "/user/register").anonymous()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().httpBasic();
        http.anonymous().authorities("ANON");
        http.csrf().ignoringAntMatchers("/**");
        /*
        http.requiresChannel().anyRequest().requiresSecure();
        http.formLogin().loginPage("/user/login");
    **/
    }
}
