package restsparketl.health.service.impl;


import restsparketl.health.Mapper.Departmentmapper;
import restsparketl.health.entity.LoginUser;
import org.springframework.stereotype.Service;
import restsparketl.health.service.UserService;
import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    public Departmentmapper departmentmapper;



    @Override
    public LoginUser getUserByName(String Username) {
        return this.departmentmapper.GetuserByName(Username);

    }

    @Override
    public int setUser(LoginUser user) {

        return this.departmentmapper.Insertuser(user);

    }
    @Override
    public  LoginUser getpassword(String password){
        return  this.departmentmapper.GetuserBypassword(password);
    }
}
