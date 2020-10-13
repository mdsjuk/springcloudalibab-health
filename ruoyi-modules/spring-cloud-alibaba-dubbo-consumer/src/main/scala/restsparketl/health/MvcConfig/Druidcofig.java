package restsparketl.health.MvcConfig;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:wxb
 * @description:
 * @date:16:192019/12/12
 */
@Configuration
public class Druidcofig {


    @Bean
    public ServletRegistrationBean ServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> map = new HashMap<>();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "740616");
        map.put("allow", "localhost");
        servletRegistrationBean.setInitParameters(map);

        return servletRegistrationBean;

    }



}
