package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product/*")
public class ProductController{
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list")
	public String getProductList() throws Exception{
		List<ProductDTO> ar =  productService.getProductList();
		System.out.println(ar.size()>0);
//		System.out.println("product List");
		// 		prefix											suffix
		//WEB-INF/views/+"product/productList"+.jsp
		return "product/productList";//주소로 리턴
	}
	//getProductDetail
	@RequestMapping(value = "detail")
	public String getProductDetail() {
		System.out.println("Product Detail");
		return "product/productDetail";
	}
	@RequestMapping(value = "productAdd")
	public void productAdd() {
		//return 값이 없으면 url 주소를 가지고 찾는다.
	}
	@RequestMapping(value = "update")
	public ModelAndView productUpdate() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		return mv;
	}
}
