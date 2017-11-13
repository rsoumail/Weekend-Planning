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
import org.springframework.mail.javamail.JavaMailSenderImpl;
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
                .antMatchers("/api/authorities").permitAll()
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/api/authentication").permitAll()
                .antMatchers("/api/all").permitAll()
                .antMatchers("/api/account/reset-password/init").permitAll()
                .antMatchers("/api/account/reset-password/finish").permitAll()
                .antMatchers("/api/profile-info").permitAll()
                .antMatchers("/api/places").permitAll()
                .antMatchers("/api/user_activities").permitAll()
                .antMatchers("/api/user_places").permitAll()
                .antMatchers("/api/add_activity").permitAll()
                .antMatchers("/api/users").permitAll()
                .antMatchers("/api/add_place").permitAll()
                .antMatchers("/api/update_user_place").permitAll()
                .antMatchers("/api/update_user_activity").permitAll()
                .antMatchers("/api/test").permitAll()
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

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable","true");
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setUsername("m2ilweekendplanning@gmail.com");
        javaMailSender.setPassword("foBdHo8Ql637");
        //javaMailSender.getJavaMailProperties().setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        javaMailSender.getJavaMailProperties().setProperty("mail.smtp.auth", "true");
        javaMailSender.setPort(587);

        try {
            //javaMailSender.testConnection();

        }catch (Exception e){

        }

        return javaMailSender;
    }
}
