package com.iu.s1.product;

import java.util.List;

public class ProductService {

	private ProductDAO productDAO;

	public ProductService() {
		this.productDAO = new ProductDAO();
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;

	}
	
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
		int result = productDAO.setAddProduct(productDTO);
		if(result>0) {
			for(ProductOptionDTO productOptionDTO : ar) {
				productOptionDTO.setOptionnum(productNum);
				result = productDAO.setAddoption(productOptionDTO);
			}
		}
		return result;
	}


}
