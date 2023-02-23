package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pager;
@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;


	
	public ProductDTO getProductDetail(ProductDTO productDTO)throws Exception{
		return productDAO.getProductDetail(productDTO);
	}


	public List<ProductDTO> getProductList(Pager pager)throws Exception{
		
		pager.makeNum(productDAO.getProductTotalCount());
		pager.makeRow();
		return productDAO.getProductList(pager);
	}


	//service ==> dao 로 보내거나 받는 역활
	public int setProductAdd(ProductDTO productDTO,List<ProductOptionDTO> ar) throws Exception{
		//product테이블에 상품등록 및 옵션 등록
		Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		int result = productDAO.setProductAdd(productDTO);
		if(ar !=null) {
			if(result>0) {
				for(ProductOptionDTO productOptionDTO : ar) {
					productOptionDTO.setOption_Num(productNum);
					result = productDAO.setAddoption(productOptionDTO);	
				}
			}
		}
		return result;
	}


}
