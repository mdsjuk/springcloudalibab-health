package restsparketl.health.Mapper;

import restsparketl.health.entity.LoginUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


/**
 * @author:wxb
 * @description:
 * @date:21:242019/12/2
 */

public interface Departmentmapper {
    @Select("select * from users where username = #{username}")
    LoginUser GetuserByName(String name);
    @Select("select * from users where password = #{password}")
     LoginUser GetuserBypassword(String password);
    @Insert("insert into users(username,password)values(#{username},#{password})")
     int Insertuser(LoginUser loginUser);



}
