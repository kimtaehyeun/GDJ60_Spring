package com.iu.s1.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class ProductDAOTest extends MyTestCase{

	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void getProductListTest() throws Exception{
		List<ProductDTO> ar =	productDAO.getProductList();
		//������
		assertNotEquals(0, ar.size());
	}
	@Test
	public void getProductDetailTest()throws Exception{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(29L);
		productDTO= productDAO.getProductDetail(productDTO	);
		assertNotNull(productDTO);
	}
	@Test
	public void setProductAddTest() throws Exception{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(1L);
		productDTO.setProductName("1������ ��");
		productDTO.setProductDetail("ga");
		int i = productDAO.setProductAdd(productDTO);
		assertEquals(1,i);
	}
}