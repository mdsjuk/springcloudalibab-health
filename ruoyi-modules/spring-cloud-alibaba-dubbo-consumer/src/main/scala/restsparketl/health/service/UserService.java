package restsparketl.health.service;

import restsparketl.health.entity.LoginUser;

public interface UserService {
	LoginUser getUserByName(String UserName);
	LoginUser getpassword(String password);
	int setUser(LoginUser user);
}
