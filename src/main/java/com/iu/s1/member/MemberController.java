package com.iu.s1.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
@Autowired
	private MemberService memberService;
	//
	@RequestMapping(value = "memberJoin",method = RequestMethod.GET)
	public ModelAndView setMemberJoin(ModelAndView mv) throws Exception {
		mv.setViewName("member/memberJoin");
		return mv;
		
	}
	@RequestMapping(value = "memberJoin",method = RequestMethod.POST)
	public ModelAndView memberJoin(ModelAndView mv, MemberDTO memberDTO) throws Exception {
		int result = memberService.setMemberAdd(memberDTO);
		mv.setViewName("redirect:../");
		return mv;
		
	}
	
	@RequestMapping(value = "memberLogin",method= RequestMethod.GET)
	public ModelAndView getMemberLogin(ModelAndView mv) {
		mv.setViewName("member/memberLogin");
		return mv;
	}
	@RequestMapping(value="memberList")
	public ModelAndView getMemberList(ModelAndView mv) throws Exception{
	List<MemberDTO> ar =memberService.getMemberList();
	System.out.println("a");
	mv.setViewName("member/memberList");
	mv.addObject("list", ar);
	return mv;
	}
	
	@RequestMapping(value = "memberPage")
	public ModelAndView getMemeberPage(MemberDTO memberDTO) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", memberDTO);
		mv.setViewName("member/memberPage");
		return mv;
	}
	
	@RequestMapping(value = "memberLogin",method= RequestMethod.POST)
	public ModelAndView getMemberLogin(ModelAndView mv, MemberDTO memberDTO, HttpServletRequest httpServletRequest) throws Exception{
		memberDTO = memberService.getMemberLogin(memberDTO);
		HttpSession session=httpServletRequest.getSession();
		session.setAttribute("member", memberDTO);
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@RequestMapping(value="memberLogout", method = RequestMethod.GET)
	public ModelAndView getMemberLogout(ModelAndView mv, HttpSession session) throws Exception {
		session.invalidate();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@RequestMapping(value="memberUpdate", method =RequestMethod.GET )
	public ModelAndView setMemberUpdate(ModelAndView mv) throws Exception{
		mv.setViewName("member/memberUpdate");
		return mv;
	}
	
	@RequestMapping(value="memberUpdate", method =RequestMethod.POST )
	public ModelAndView setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO sesssionMemberDTO= (MemberDTO)session.getAttribute("member");
		memberDTO.setId(sesssionMemberDTO.getId());
		int result =memberService.setMemberUpdate(memberDTO);
		if(result>0) {
			session.setAttribute("member",memberDTO);
		}
		mv.setViewName("redirect:./memberPage");
		return mv;
	}
	
}
