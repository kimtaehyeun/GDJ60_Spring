package com.iu.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/bankBook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBankBookList(ModelAndView mv, Pager pager) throws Exception{
		
		List<BankBookDTO> ar = bankBookService.getBankBookList(pager);
		
		mv.setViewName("bankBook/list");
		mv.addObject("list", ar);
		mv.addObject("pager",pager);
		return mv;
	}
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getBankBookDetail(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		mv.setViewName("bankBook/detail");
		mv.addObject("dto", bankBookDTO);
		return mv;
	}
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView setBankBookAdd(ModelAndView mv) throws Exception{
		mv.setViewName("bankBook/add");
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView setBankBookAdd(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		int result = bankBookService.setBankBookAdd(bankBookDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView setBankBookDelete(BankBookDTO bankBookDTO , ModelAndView mv) throws Exception{
		int result  =bankBookService.setBankBookDelete(bankBookDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		bankBookDTO= bankBookService.getBankBookDetail(bankBookDTO);
		mv.addObject("dto",bankBookDTO);
		mv.setViewName("bankBook/update");
		return mv;
	}
	@RequestMapping(value="update", method = RequestMethod.POST)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		int result =bankBookService.setBankBookUpdate(bankBookDTO);
		
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("redirect:./detail?bookNumber="+bankBookDTO.getBookNumber());
		return mv;
	}
}
