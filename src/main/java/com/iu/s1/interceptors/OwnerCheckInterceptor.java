package com.iu.s1.interceptors;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.board.qna.QnaDAO;
import com.iu.s1.member.MemberDTO;

@Component
public class OwnerCheckInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//번호로 작성자를 어떻게 받아오나?
		//1. 요청된 파라미터 가져오기
		Long num= Long.parseLong(request.getParameter("num")) ;
		//2. 요청한 uri주소 가져오기
		String uri = request.getRequestURI();		
		
		//3. board에 notice인지 qna인지 검증
		uri =uri.substring(1,uri.lastIndexOf("/")); 
		BoardDTO boardDTO =  new BoardDTO();
		boardDTO.setNum(num);
		//4. 작성한 보드의 모든 정보 가져오기(writer비교를 위해)
		if(uri.equals("notice")) {
			boardDTO = noticeDAO.getBoardDetail(boardDTO);
		}
		else {
			boardDTO= qnaDAO.getBoardDetail(boardDTO);
		}
		//5. 세션에 있는 로그인한 아이디 가져오기
		MemberDTO memberDTO= (MemberDTO)request.getSession().getAttribute("member");
		if(!memberDTO.getId().equals(boardDTO.getWriter())) {
			request.setAttribute("result", "작성자만 가능");
			request.setAttribute("url", "./list");
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			
			return false;
		}
		return true;
	}
	
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		System.out.println("onercheckInterceptor");
//				
//		//1. 로그인 한 사용자의 아이디
//		MemberDTO memberDTO =  (MemberDTO)request.getSession().getAttribute("member");
//		//2. BoardDTO
//		Map<String, Object> map=  modelAndView.getModel();
//		BoardDTO boardDTO = (BoardDTO)map.get("dto");
////		map.keySet().iterator();
//		
//		//3. check 로그인한 사용자 id = writer
//		if(memberDTO==null	||	!boardDTO.getWriter().equals(memberDTO.getId())) {
//			modelAndView.setViewName("common/result");
//			modelAndView.addObject("result", "권한이없습니다.");
//			modelAndView.addObject("url", "./list");
//		}
//		
//	}

}
