package fr.istic.m2il.weekendplanning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * This section defines the user accounts which can be used for authentication as well as the roles each user has.
     *
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().//
                withUser("greg").password("turnquist").roles("USER").and().//
                withUser("ollie").password("gierke").roles("USER", "ADMIN");
    }

    /**
     * This section defines the security policy for the app.
     * <p>
     * <ul>
     * <li>BASIC authentication is supported (enough for this REST-based demo).</li>
     * <li>/employees is secured using URL security shown below.</li>
     * <li>CSRF headers are disabled since we are only testing the REST interface, not a web one.</li>
     * </ul>
     * NOTE: GET is not shown which defaults to permitted.
     *
     * @param http
     * @throws Exception
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
                .and().authorizeRequests().//
                antMatchers("/").permitAll().//
                antMatchers(HttpMethod.GET, "/api/").authenticated().//
                antMatchers(HttpMethod.POST, "/api").hasRole("USER").//
                antMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN").//
                antMatchers(HttpMethod.PATCH, "/api/**").hasRole("ADMIN")
                .and().//
                csrf().disable()
                .formLogin()
                .loginProcessingUrl("/api/authentication")
                //.successHandler(ajaxAuthenticationSuccessHandler())
               // .failureHandler(ajaxAuthenticationFailureHandler())
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/api/logout")
                //.logoutSuccessHandler(ajaxLogoutSuccessHandler())
                .permitAll()
                ;
    }
}
