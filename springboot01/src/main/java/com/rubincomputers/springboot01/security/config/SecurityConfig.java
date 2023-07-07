package com.rubincomputers.springboot01.security.config;

import com.rubincomputers.springboot01.security.filter.TokenAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private TokenAuthFilter tokenAuthFilter;




    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http
                .authorizeRequests()
                    .antMatchers("/users/**").authenticated()
                    .and()
                .formLogin()
                .loginPage("/login");
        http.csrf().disable();*/

        http
                .addFilterBefore(tokenAuthFilter, BasicAuthenticationFilter.class)
                .antMatcher("/**")
                .authenticationProvider(authenticationProvider)
                .authorizeRequests()
                    .antMatchers("/users/**").hasAuthority("ROLE_ADMIN")
                    .antMatchers("/login", "/signup").permitAll()
                    .antMatchers("/static/**").permitAll()
                //---rest
                .antMatchers(HttpMethod.POST, "/rest/users").permitAll()
                .antMatchers("/rest/login").permitAll()
                //.antMatchers("/rest/**").authenticated()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .usernameParameter("login")
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .permitAll()
                    .and()
                .rememberMe()
                .rememberMeParameter("remember-me")
                .tokenRepository(tokenRepository())
                .and()
                .logout()
                    .logoutUrl("/logout")
                .permitAll();
        http.csrf().disable();
    }

    @Bean(value = "sessionTokenRepository")
    public PersistentTokenRepository tokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        if (!isTokenTableExists()){
            tokenRepository.setCreateTableOnStartup(true);
        }

        return tokenRepository;
    }

    private boolean isTokenTableExists(){
        // Check if the table exists before creating it
        boolean tableExists = false;
        try (Connection conn = dataSource.getConnection();
             ResultSet rs = conn.getMetaData().getTables(null, null, "PERSISTENT_LOGINS", null)) {
            if (rs.next()) {
                tableExists = true;
            }
        } catch (SQLException e) {
            // Handle the exception
        }
        return tableExists;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
