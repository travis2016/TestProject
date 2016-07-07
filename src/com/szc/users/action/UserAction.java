package com.szc.users.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import sun.util.logging.resources.logging;

import com.opensymphony.xwork2.ActionSupport;
import com.szc.users.beans.UserBean;
import com.szc.users.service.UserService;

/**
 * 
 * @author TravisSong
 * UserAction负责处理用户表的一些操作
 */
public class UserAction  extends ActionSupport {
    
	private static final long serialVersionUID = 1L;  
    private HttpServletRequest request;
  	private HttpServletResponse response;
  	private ServletContext Context;
  	private WebApplicationContext ctx;
  	 
    
  	public UserAction() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=UTF-8");//设置传输编码
		Context = ServletActionContext.getServletContext();
		ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(Context);
//		response.setContentType("text/json");
  	}
  	
  	
	
	@Action(value = "/selectAction")//ajax的方法，返回的Type必须是json
	public void selectUser() {
		System.out.println("here");
		UserBean selectUser=new UserBean();
		UserService server = ctx.getBean("services",com.szc.users.service.Impl.UserServiceImpl.class);
    	List<UserBean> userList=server.searchUser();
    	LOG.info(userList.get(0).getNickname());
	}
}
