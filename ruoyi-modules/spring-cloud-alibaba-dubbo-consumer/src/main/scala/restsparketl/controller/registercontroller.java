package restsparketl.controller;

import restsparketl.health.entity.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import restsparketl.health.service.UserService;


import javax.annotation.Resource;

/**
 * @author:wxb
 * @description:
 * @date:17:212019/11/21
 */
@Controller
public class registercontroller {
    @Resource
    public UserService userService;
    @RequestMapping(value = "/toRegister",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String toRegister(@RequestParam String username, @RequestParam String password){
        System.out.println(username+password);
        if ( this.userService.getUserByName(username)==(null)) {
            int insertnumber = this.userService.setUser(new LoginUser(username,password));

            return insertnumber + " ";


        }else {return "repeat username";}
    }

}
