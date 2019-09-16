package com.carl.study.springboot.springbootinterceptor;

import com.carl.study.springboot.springbootinterceptor.interceptor.LoginInterceptor;
import com.carl.study.springboot.springbootinterceptor.interceptor.UploadInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringbootInterceptorApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootInterceptorApplication.class, args);
    }

    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Bean
    public UploadInterceptor uploadInterceptor(){
        return new UploadInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
        1. 多个拦截器默认情况下按照添加顺序调用, 如下先调用uploadInterceptor, 再调用loginInterceptor
        2. 可以通过调用order()方法并传入顺序数字, 指定拦截器的调用顺序
        3. 某一拦截器返回false后, 则后续拦截器不再执行
        4. 一个拦截器的"拦截路径"和"排除路径"有冲突时, 可以再调用一次registry.addInterceptor方法, 如下面的loginInterceptor拦截器的配置
        5. 拦截器的路径可以不包含配置文件中的上下文路径(如果发现拦截器没有生效可以考虑 添加或者删除上下文路径前缀"试试")
         */
        registry.addInterceptor(uploadInterceptor()) //.order(2) // 指定拦截器调用顺序
                .addPathPatterns("/**");

        registry.addInterceptor(loginInterceptor()) //.order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/register/**");

        registry.addInterceptor(loginInterceptor()) // 默认按照addInterceptor的顺序调用拦截器
                .addPathPatterns("/api/register/logout");

    }
}
