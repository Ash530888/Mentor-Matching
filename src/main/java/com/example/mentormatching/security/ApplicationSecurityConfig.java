package com.example.mentormatching.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/home").authenticated()

                .and()
                .formLogin()
                        .loginPage("/login")
                        .loginProcessingUrl("/checkUserAccount")
                        .defaultSuccessUrl("/home")
                        .permitAll()
                    .and()
                        .logout()
                        .logoutSuccessUrl("/welcomePage")
                        .invalidateHttpSession(true)
                        .permitAll();



    }
}
