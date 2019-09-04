package org.lanqiao.jd.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration loginRegistry = registry.addInterceptor(new CheckLogInterceptor()).addPathPatterns("/**");
        // 拦截路径
        loginRegistry.addPathPatterns("/**");
        // 排除路径
//        loginRegistry.excludePathPatterns("/");
        loginRegistry.excludePathPatterns("/jdlogin.html");
        loginRegistry.excludePathPatterns("/jdhomepage.html");
        loginRegistry.excludePathPatterns("/zhuce.html");
        loginRegistry.excludePathPatterns("/zhuce2.html");
        loginRegistry.excludePathPatterns("/checkUser");
        loginRegistry.excludePathPatterns("/checkUserName");
        loginRegistry.excludePathPatterns("/checkUserStatus");
        loginRegistry.excludePathPatterns("/changeUserStatus");
        loginRegistry.excludePathPatterns("/checkTel");
        loginRegistry.excludePathPatterns("/insert");

        loginRegistry.excludePathPatterns("/shangpin.html");
        loginRegistry.excludePathPatterns("/getgoods");
        loginRegistry.excludePathPatterns("/writecart");
        loginRegistry.excludePathPatterns("/updatecart");
        loginRegistry.excludePathPatterns("/getfsort");
        loginRegistry.excludePathPatterns("/getimages");
        loginRegistry.excludePathPatterns("/getssort");
        loginRegistry.excludePathPatterns("/cwfooter.html");

        loginRegistry.excludePathPatterns("/search.html");
        loginRegistry.excludePathPatterns("/fuzzySearch");
        loginRegistry.excludePathPatterns("/orderBy");
        loginRegistry.excludePathPatterns("/priceInterval");
        loginRegistry.excludePathPatterns("/brandSearch");
        loginRegistry.excludePathPatterns("/insertBrand");
        loginRegistry.excludePathPatterns("/selectRank");
        loginRegistry.excludePathPatterns("/selectDetail");







        // 排除资源请求
        loginRegistry.excludePathPatterns("/css/*.css");
        loginRegistry.excludePathPatterns("/js/*.js");
        loginRegistry.excludePathPatterns("/image/*.png");
        loginRegistry.excludePathPatterns("/image/*.jpg");
        loginRegistry.excludePathPatterns("/image/*.gif");
        loginRegistry.excludePathPatterns("/image/*.webp");
        super.addInterceptors(registry);
    }
}