package com.iu.s1.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.member.MemberDAO;
@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private MemberDAO memberDAO;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//Controller 진입 전
		//return = true 면 다음 Controller로 진행
		//return = false 면 진행 X => 개발자가 다른곳으로 경로를 보내줘야함.
		//		System.out.println("memberCheckInterceptor");
		if(request.getSession().getAttribute("member")!=null) {
			return true;
		}
		//		System.out.println("Controller 진입 전 체크");
		//		System.out.println("로그인 안한경우");

		///1. Foward JSP
		//		request.setAttribute("result", "권한이 없습니다");
		//		request.setAttribute("url", "../member/memberLogin");
		//		RequestDispatcher view=request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		//		view.forward(request, response);

		//2. Redirect
		response.sendRedirect("../../../../../../../../../../../../../../member/memberLogin");
		return false;
	}

}
