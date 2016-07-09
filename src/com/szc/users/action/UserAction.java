package com.szc.users.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
    	List userList=server.searchUser();
    	Object[] user1=(Object[])userList.get(0);
    	JSONArray selectResult = JSONArray.fromObject(userList);
    	int userid=(Integer)user1[0];
    	String userName=(String)user1[1];
    	System.out.println(userid);
    	System.out.println(userName);
    	System.out.println(selectResult.toString());
	}
}
