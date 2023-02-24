package com.iu.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;//BbsService, QnaService 타입 둘다 가능
	
	@ModelAttribute("boardName")
	public String getBoardName() {
		return "qna";
		
		//스프링이 호출하게 만들어야함.
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BbsDTO> ar = qnaService.getBoardList(pager);
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		return mv;
	}
	@GetMapping("add")
	public ModelAndView setBoardAdd()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/add");
		return mv;
	}
	@PostMapping("add")
	public ModelAndView setBoardAdd(QnaDTO qnaDTO, ModelAndView mv)throws Exception{
		int result = qnaService.setBoardAdd(qnaDTO);
		
		String message="실패";
		if(result>0) {
			message="성공";
			
		}
		mv.addObject("url","./list");
		mv.addObject("result", message);
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getBoardDetail(QnaDTO qnaDTO, ModelAndView mv) throws Exception{
		BoardDTO boardDTO= qnaService.getBoardDetail(qnaDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("./board/detail");
		return mv;
	}
	@GetMapping("reply")
	public ModelAndView setReplyAdd(BoardDTO qnaDTO, ModelAndView mv)throws Exception{
		mv.setViewName("board/reply");
		return mv;
	}
	
	
	@PostMapping("reply")
	public ModelAndView setReplyAdd(QnaDTO qnaDTO, ModelAndView mv)throws Exception{
		int result = qnaService.setReplyAdd(qnaDTO);
		String name ="등록 실패";
	      
	      if(result>0) {
	         name = "글이 등록되었습니다";
	      }
	      mv.addObject("url","./detail?num="+qnaDTO.getNum());
	      mv.addObject("result", name);
	      mv.setViewName("common/result");
		return mv;
	}
}
