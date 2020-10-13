package restsparketl.health.service.impl;


import com.uber.engsec.dp.examples.QueryRewritingExample;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import spring.cloud.alibaba.dubbo.api.RW;

/**
 * @author:wxb
 * @description:
 * @date:19:372020/9/19
 */
@Service
@Component
public class RWimp implements RW {
    @Override
    public String RW() {
        return  QueryRewritingExample.elasticSensitivityExample();
    }
}
