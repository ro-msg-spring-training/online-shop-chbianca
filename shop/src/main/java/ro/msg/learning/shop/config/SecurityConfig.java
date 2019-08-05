package ro.msg.learning.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ro.msg.learning.shop.services.UserDetailsService;

import java.util.Map;

@Configuration
public class SecurityConfig {

    private UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        Map<String, String> map = userDetailsService.getUsernamesAndPasswords();
        map.forEach((key, value) -> {
            try {
                auth.inMemoryAuthentication()
                        .withUser(key).password("{noop}" + value).roles("USER").and();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    @Profile("dev")
    @Configuration
    public static class FormBasedSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/user/**").hasRole("USER")
                    .antMatchers("/", "/order/create", "/product/**", "/h2/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
            ;
            http.headers().frameOptions().disable();
        }
    }

    @Profile("!dev")
    @Configuration
    public static class HttpBasicSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.csrf().disable()
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic()
            ;
            http.headers().frameOptions().disable();
        }
    }
}

