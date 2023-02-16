package com.iu.s1.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.Pager;

@Controller
@RequestMapping(value = "/product/*")
public class ProductController{
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list")
	public ModelAndView getProductList(ModelAndView mv, Pager pager) throws Exception{
//		ModelAndView mv = new ModelAndView();
		
		List<ProductDTO> ar =  productService.getProductList(pager);
		System.out.println(ar.size()>0);
		mv.setViewName("product/productList");
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
//		System.out.println("product List");
		// 		prefix											suffix
		//WEB-INF/views/+"product/productList"+.jsp
		return mv;//주소로 리턴
	}
	//getProductDetail
	@RequestMapping(value = "detail")
	public String getProductDetail(ProductDTO productDTO, Model model) throws Exception{
		//파라미터 이름과 setter의 이름이 같아야함
		System.out.println("product detail");
		productDTO = productService.getProductDetail(productDTO);
		
		model.addAttribute("dto", productDTO);
		System.out.println(productDTO!= null);
		return "product/productDetail";
	}

	
	@RequestMapping(value = "productAdd" , method = RequestMethod.GET)
	public void setProductAdd() {
		//return 값이 없으면 url 주소를 가지고 찾는다.
	}
	@RequestMapping(value = "productAdd", method = RequestMethod.POST)
	public String productAdd(ProductDTO productDTO) throws Exception {
		int result = productService.setProductAdd(productDTO, null);
		System.out.println(result ==1);
		return "redirect:./list";
	}
	@RequestMapping(value = "update")
	public ModelAndView productUpdate() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
	
		return mv;
	}
}
