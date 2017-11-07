package fr.istic.m2il.weekendplanning.config;

import fr.istic.m2il.weekendplanning.security.DomainUserDetailsService;
import fr.istic.m2il.weekendplanning.security.MySavedRequestAwareAuthenticationSuccessHandler;
import fr.istic.m2il.weekendplanning.security.RestAuthenticationEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan({"fr.istic.m2il.weekendplanning"})
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final Logger log = LoggerFactory.getLogger(SecurityConfiguration.class);

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private MySavedRequestAwareAuthenticationSuccessHandler
            authenticationSuccessHandler;

    @Autowired
    private DomainUserDetailsService userDetailsService;

    @Autowired
    private  AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private PasswordEncoder passwordEncoder ;

    /**
     * This section defines the user accounts which can be used for authentication as well as the roles each user has.
     *
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        /*auth.inMemoryAuthentication()
                .withUser("temporary").password("temporary").roles("ADMIN")
                .and()
                .withUser("user").password("userPass").roles("USER");*/
        log.info("Authenticating {} Debut configgggggg");

        auth.authenticationProvider(authenticationProvider());
    }

 /*   @PostConstruct
    public void init() {
        try {
            log.info("Authenticating {} Debut configgggggg");
            authenticationManagerBuilder
                    .userDetailsService(userDetailsService)
                    .passwordEncoder(passwordEncoder());
            log.info("Fin configggggggggggggg");
        } catch (Exception e) {
            throw new BeanInitializationException("Security configuration failed", e);
        }
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .formLogin()
                .loginProcessingUrl("/api/authentication")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/api/register").permitAll()
                .antMatchers("/api/activate").permitAll()
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/api/account/reset-password/init").permitAll()
                .antMatchers("/api/account/reset-password/finish").permitAll()
                .antMatchers("/api/profile-info").permitAll()
                .antMatchers("/api/**").authenticated();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler(){
        return new MySavedRequestAwareAuthenticationSuccessHandler();
    }
    @Bean
    public SimpleUrlAuthenticationFailureHandler myFailureHandler(){
        return new SimpleUrlAuthenticationFailureHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
