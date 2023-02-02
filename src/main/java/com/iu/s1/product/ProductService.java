package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public ProductDTO getProductDetail(ProductDTO productDTO)throws Exception{
		return productDAO.getproductDetail(productDTO);
	}
	
	
	public List<ProductDTO> getProductList()throws Exception{
		return productDAO.getProductList();
	}


	//service == dao 로 보내거나 받는 역활
	public int setAddProduct(ProductDTO productDTO,List<ProductOptionDTO> ar) throws Exception{
		//product테이블에 상품등록 및 옵션 등록
		Long productNum = productDAO.getProductNum();
		productDTO.setNum(productNum);
		int result = productDAO.SetAddProduct(productDTO);
		if(result>0) {
			for(ProductOptionDTO productOptionDTO : ar) {
				productOptionDTO.setOptionnum(productNum);
				result = productDAO.setAddoption(productOptionDTO);
			}
		}
		return result;
	}


}
