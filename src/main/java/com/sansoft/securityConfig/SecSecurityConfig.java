package com.sansoft.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Sandroid on 3/29/2018.
 */
@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/assets/**","/bower_components/**","/sign-in").permitAll()
                .antMatchers("/index").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().successHandler(mySimpleUrlAuthenticationSuccessHandler).loginPage("/sign-in");
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/sign-in").deleteCookies();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("sanlama21@gmail.com").password(new BCryptPasswordEncoder().encode("sanlama")).roles("ADMIN")
                .and()
                .withUser("test@gmail.com").password(new BCryptPasswordEncoder().encode("sanlama")).roles("USER");
    }

}
