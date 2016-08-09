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
        //获取拦截的Action名称
        String invocationAction=invocation.getAction().getClass().getName();
        String invocationname= invocationAction.substring(invocationAction.lastIndexOf(".")+1,invocationAction.length());
        System.out.println("invocationAction=="+invocationAction);
        Map session = ctx.getSession();
		System.out.println("执行拦截器");
		
		if(invocationname=="RegisterAction" || invocationname=="LoginUserAction"){
			result="true";
		}
		return "false";
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}

}
