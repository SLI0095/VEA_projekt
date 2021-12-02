package cz.vsb.SLI0095_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers( "/editUser").hasAnyRole( "ADMIN")
                .antMatchers("/newRating").hasAnyRole("ADMIN", "USER")
                .antMatchers("/newBook", "newAuthor").hasAnyRole("ADMIN")
                .antMatchers( "/saveAuthor", "/saveBook", "/saveUser").hasAnyRole("ADMIN")
                .and()
                .formLogin()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin").roles("USER","ADMIN");
    }
}
