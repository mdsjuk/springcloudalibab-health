package restsparketl.controller;


import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.cloud.alibaba.dubbo.api.DP_noise;
import spring.cloud.alibaba.dubbo.api.RW;

@Controller
public class EntryController {

    @Reference
    private RW rw;
    @Reference
    private DP_noise dp_noise;


    @RequestMapping(value = "/Lp")
    @ResponseBody
    public String Laplace(){
        return dp_noise.noise();

    }
    @RequestMapping(value = "/R")
    @ResponseBody
    public String Rewriting(){
        return  rw.RW();

    }
}

