package com.iu.s1.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberJoin")
	public String join() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("asdfdf");
		memberDTO.setPw("asdf");
		memberDTO.setName("asdf");
		memberDTO.setPhone("asdf");
		memberDTO.setEmail("asdf");
		memberDTO.setAddress("asdf");
		
		try {
			int result =memberService.memberJoin(memberDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "member/memberJoin";
		
	}
	@RequestMapping(value = "memberLogin")
	public void Login() {
		
	}
	@RequestMapping(value="memberList")
	public ModelAndView getMemberList() throws Exception{
	List<MemberDTO> ar =memberService.getMemberList();
	ModelAndView mv = new  ModelAndView();
	mv.addObject("list", ar);
	return mv;
	}
	@RequestMapping(value = "memberPage")
	public ModelAndView mypage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberpage");
		return mv;
	}
	
	public void Join() {
		
	}
}
