package cn.itcast.acton;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.entity.User;
import cn.itcast.service.UserService;

@SuppressWarnings("all")
public class UserAction extends ActionSupport {
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private String username;
	private String password;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public  String login() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		User userExit = userService.login(user);
		
		if(userExit != null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", userExit);;
			return "loginSuccess";
		}else {
			return "login";	
		}
	}
}
