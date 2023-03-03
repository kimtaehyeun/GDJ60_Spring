package com.iu.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.member.MemberDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping(value = "/bankBookComment/*")
public class BankBookCommentController {
	
	@Autowired
	private BankBookCommentService bankBookCommentService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(ModelAndView mv, Pager pager)throws Exception{
		
		List<BbsDTO>ar =  bankBookCommentService.getBoardList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("common/CommentList");
		return mv;
	}
	@PostMapping("add")
	public ModelAndView setBoardAdd(BankBookCommentDTO bankBookCommentDTO,HttpSession session)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
//		bankBookCommentDTO.setWriter(memberDTO.getId());
//		
		bankBookCommentDTO.setWriter("d");
		int result = bankBookCommentService.setBoardAdd(bankBookCommentDTO, null, session);
		mv.addObject("result", result);
		mv.setViewName("common/result2");
		
		return mv;
		
	}
	
}
