package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/product/*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list")
	public String getProductList() throws Exception {
		
	List<ProductDTO> ar=	productService.getProductList();
	return "product/list";
	}
	
	
}
