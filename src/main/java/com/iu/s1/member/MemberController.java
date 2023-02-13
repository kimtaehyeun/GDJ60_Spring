package com.iu.s1.member;

import java.util.ArrayList;
import java.util.List;

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
		int result = memberService.setMemberJoin(memberDTO);
		mv.setViewName("redirect:./memberList");
		return mv;
		
	}
	
	@RequestMapping(value = "memberLogin")
	public void Login() {
		
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
	public ModelAndView mypage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		return mv;
	}
}
