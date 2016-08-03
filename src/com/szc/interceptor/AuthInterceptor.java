package com.szc.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


/**
 * 
 * @author travissong
 * 拦截器
 *
 */
public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = "";  
        ActionContext ctx = invocation.getInvocationContext();    
        Map session = ctx.getSession();
		
		return null;
	}

}
