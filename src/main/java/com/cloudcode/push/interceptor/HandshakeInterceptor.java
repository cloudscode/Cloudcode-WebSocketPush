package com.cloudcode.push.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;


@Component
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {

	@Override
	public boolean beforeHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
			System.out.println("Before Handshake");
	        ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;  
	        HttpServletRequest httpServletRequest = servletRequest.getServletRequest();  
	        List<String> parameterNames = new ArrayList<String>(httpServletRequest.getParameterMap().keySet());
	        for(String key:parameterNames){
	        	attributes.put(key, httpServletRequest.getParameter(key));  
	        }
	        attributes.put("sessionId", httpServletRequest.getSession().getId());
		return super.beforeHandshake(request, response, wsHandler, attributes);
	}

	@Override
	public void afterHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
			System.out.println("After Handshake");
		super.afterHandshake(request, response, wsHandler, ex);
	}
	

}
