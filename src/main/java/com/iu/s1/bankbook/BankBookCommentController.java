package com.iu.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping(value = "/bankBookComment/**")
public class BankBookCommentController {
	
	@Autowired
	private BbsService bankBookCommentService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(ModelAndView mv, Pager pager)throws Exception{

		List<BbsDTO>ar =  bankBookCommentService.getBoardList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("board/lsit");
		return mv;
	}
}