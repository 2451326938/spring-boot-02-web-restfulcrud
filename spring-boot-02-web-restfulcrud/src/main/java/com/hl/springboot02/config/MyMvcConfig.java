package com.hl.springboot02.config;

import com.hl.springboot02.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// 使用WebMvcConfigureAdapter可以扩展SpringMvc的功能
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        registry.addViewController("/hello").setViewName("success");
    }

    // 所有的WebMvcConfigurerAdapter组件会一起起作用
    @Bean // 将组件注册在容器
    public WebMvcConfigurerAdapter WebMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry){
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors(registry);
                // springboot 已经做好了静态资源的拦截功能，所以不需要处理
                  registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                          .excludePathPatterns("/","/index.html","/user/login");
            }
        };
        return adapter;
    }
}
