package com.codegym.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                //người dùng đăng nhập
                .withUser("thanh123").password("{noop}123456").roles("USER");
//               //admin đăng nhâp
//                .and()
//                .withUser("admin").password("{noop}12345").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Các trang không yêu cầu login như vậy ai cũng có thể vào được
        // user hoặc guest có thể vào các trang
        http.authorizeRequests().antMatchers("/blog").permitAll()
                //chỉ có người dùng mới được viết blog
                .and()
                .authorizeRequests().antMatchers("/blog/user**").hasRole("USER")
                //form login
                .and()
                .formLogin()
                // Cấu hình cho Logout Page. Khi logout mình trả về trang
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

}