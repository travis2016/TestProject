package com.szc.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


/**
 * 
 * @author travissong
 * 拦截器
 *
 */
public class AuthInterceptor implements Interceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = "";  
        ActionContext ctx = invocation.getInvocationContext();    
        Map session = ctx.getSession();
		System.out.println("执行拦截器");
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
