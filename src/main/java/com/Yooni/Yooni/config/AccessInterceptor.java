package com.Yooni.Yooni.config;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.Yooni.Yooni.Service.UserService;

import net.minidev.json.JSONObject;

@Component
public class AccessInterceptor implements HandlerInterceptor{
	
	@Autowired
	public UserService UserS;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		if(handler instanceof HandlerMethod) {
			String url = request.getRequestURI();
			if(url.matches("/api/.*")) {
				if(!url.equals("/api/login") && !url.equals("/api/register")) {
					String token = request.getHeader("Api-Token");
					if(token == null)
						return false;
					if(!UserS.CheckToken(token)) {
						response.setCharacterEncoding("UTF-8");  
						response.setContentType("application/json; charset=utf-8");
						PrintWriter out = null ;
					    JSONObject res = new JSONObject();
					    res.put("code", -2);
					    res.put("message", "token过期");
					    out = response.getWriter();
					    out.append(res.toString());
					    out.close();
					    return false;
					}
					else
						return true;
				}
				else {
					return true;
				}
			}
			//HandlerMethod HM = (HandlerMethod) handler;
			//Privilege privilege = HM.getMethodAnnotation(Privilege.class);
			//int value = privilege.value();
		}
		return true;
	}
	
}
