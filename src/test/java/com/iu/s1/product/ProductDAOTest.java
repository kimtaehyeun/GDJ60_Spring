package com.iu.s1.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class ProductDAOTest extends MyTestCase{

	@Autowired
	private ProductDAO productDAO;
	
//	@Test
//	public void getProductListTest() throws Exception{
//		List<ProductDTO> ar =	productDAO.getProductList();
//		//¥‹¡§πÆ
//		assertNotEquals(0, ar.size());
//	}
//	@Test
	public void getProductDetailTest()throws Exception{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(29L);
		productDTO= productDAO.getProductDetail(productDTO	);
		assertNotNull(productDTO);
	}
	@Test
	public void setProductAddTest() throws Exception{
		for(int i=0; i<30;i++) {
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setProductName("test123"+i);
		productDTO.setProductDetail("ga");
		productDTO.setProductJumsu(1.0);
		
		int result = productDAO.setProductAdd(productDTO);
		}
		
	}
}
