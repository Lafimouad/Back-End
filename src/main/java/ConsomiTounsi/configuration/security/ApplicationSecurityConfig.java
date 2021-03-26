package ConsomiTounsi.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

    //configure authorities
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorise any authenticated requests through basic auth
        // .httpBasic() :(-) of basic auth is that you can never log out
        http    .csrf().disable() //to be able to use postman
                .authorizeRequests()
                //whitelist for webpages you can access with no auth
                .antMatchers("/register/**").permitAll()
                .antMatchers("/manager/**").hasRole("MANAGER")
                .antMatchers("/admin/**").hasAnyRole("ADMIN" , "MANAGER")
                .antMatchers("/client/**").hasAnyRole("ADMIN" , "CLIENT" , "MANAGER")
                .antMatchers("/deliverer/**").hasAnyRole("DELIVERER" , "ADMIN" , "MANAGER")
                .antMatchers("/**").permitAll()
                .and().httpBasic();
                //.formLogin();
    }

    //configure authentication

    @Autowired
    UserDetailsService userDetailsService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

}