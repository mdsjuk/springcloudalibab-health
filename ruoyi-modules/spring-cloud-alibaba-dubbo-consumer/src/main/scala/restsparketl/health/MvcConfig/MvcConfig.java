package restsparketl.health.MvcConfig;

/**
 * @author:wxb
 * @description:
 * @date:20:072019/12/9
 */

import restsparketl.health.Intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    final String[] excludepath={"/druid","/","/toIndex","/toRegister","/register","/css/**","/images/**","/data/**","/js/**",
    "/lib/**","/Lp","/R"};
    @Resource
    public LoginIntercepter loginIntercepter;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/console").setViewName("pages/console");
        registry.addViewController("/console1").setViewName("pages/console1");
        registry.addViewController("/user").setViewName("pages/member/user");

    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercepter).addPathPatterns("/**").excludePathPatterns(excludepath);
    }
}
