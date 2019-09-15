package com.carl.study.springboot.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import javax.sql.DataSource;
import java.util.Arrays;


/**
 * @author changez
 * @desc spring security相关配置
 * @datetime 2019/9/14 13:24
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${data.security.secret:sijx}")
    private String pwdSercet;

    @Autowired
    private DataSource dataSource;
    /**
     * 用户认证
     * 用户认证相关操作, 登录成功/失败(username, password)
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 1. 使用Pbkdf2PasswordEncoder时需要注意生成密码的secret和校验的secret保持一致
        // 2. Pbkdf2PasswordEncoder 和 BCryptPasswordEncoder的密码格式存在很大差别, 需要注意
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(pwdSercet); // 加密盐值
        // zona-p, carl-p
        String zonaPassword = "c7352adbbe76c6dc6c88f932a27b6ca43b0be75d6a2b9dce316f3d1902fdc9706185ac589ee28f1c";
        String carlPassword = "4beb99d90450790cb4b355d3dd2b68027d091df639fffad720794cf44bd85c88e824ebe07d20ba1c";

//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        // zona-p, carl-p
//        String zonaPassword = "$2a$10$ot2Axdw3xzQWFsM1PCdtf.Nuev098oIvpPmp/lhrAGSj2OnVXP9RW";
//        String carlPassword = "$2a$10$0YjqK2Hp/JTqR4EXsSN64eoLuE9RZWyJfNLZR5vTHZz5q2UYKp3VG";

        //==========内存数据库======================
//        auth.inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder)
//                .withUser("zona")
//                .password(zonaPassword)
//                .roles("admin", "sale")
//
//                .and()
//                .withUser("carl")
//                .password(carlPassword)
//                .roles("admin")
////        .authorities("auth") // roles内部还是调用了authorities方法, 在掉之前对角色加了ROLE_的前缀
//        ;



        //============关系数据库====================
//        auth.jdbcAuthentication()
//                .passwordEncoder(passwordEncoder)
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select tt.username, tt.password,1 from (select t.user_name username, t.pwd password from t_user t ) tt where tt.username=?")
//                .authoritiesByUsernameQuery("select * from t_user_role t where t.username=?");

        //==============自定义验证器======================
        // UserDetails username
        auth.userDetailsService(username -> {

            // 1. 获取用户 db or redis
            // 2. 构造当前用户的角色信息
            GrantedAuthority authority = new SimpleGrantedAuthority("");
            GrantedAuthority authority2 = new SimpleGrantedAuthority("");

            // 3. 构造UserDetails对象
            return new User("", "", Arrays.asList(authority, authority2));
        }).passwordEncoder(passwordEncoder);
    }

    /**
     * 请求限制
     * 用户权限相关操作, 有权限访问A接口, 没权限访问A接口
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 仅对签名成功的用户请求
                .authorizeRequests()
                // 任意请求; 还有其他的模式如匹配模式: .antMatchers()
                .anyRequest()
                // 对所有签名成功的用户允许方法 ?TODO 和authorizeRequests的区别是啥?
                .authenticated()

                // 连接词, 获取最初的httpSecurity
                .and()
                // 使用默认的spring security的登录界面
                .formLogin()
                .and()
                // http的基础认证
                .httpBasic()
                ;
    }
}
