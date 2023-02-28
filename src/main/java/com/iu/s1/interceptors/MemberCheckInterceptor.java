package com.iu.s1.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//Controller 진입 전
		//return = true 면 다음 Controller로 진행
		//return = false 면 진행 X => 개발자가 다른곳으로 경로를 보내줘야함.
		boolean check  = true;
		if(request.getSession().getAttribute("member")==null) {
			
			response.sendRedirect("../member/memberLogin");
			check = false;
		}
		
		System.out.println("Controller 진입 전 체크");
		return check;
	}
	
}
