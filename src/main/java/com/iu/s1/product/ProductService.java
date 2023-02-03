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


	//service ==> dao �� �����ų� �޴� ��Ȱ
	public int setAddProduct(ProductDTO productDTO,List<ProductOptionDTO> ar) throws Exception{
		//product���̺��� ��ǰ��� �� �ɼ� ���
		Long productNum = productDAO.getProductNum();
		productDTO.setNum(productNum);
		int result = productDAO.SetAddProduct(productDTO);
		if(ar !=null) {
			if(result>0) {
				for(ProductOptionDTO productOptionDTO : ar) {
					productOptionDTO.setOptionnum(productNum);
					result = productDAO.setAddoption(productOptionDTO);
				}
			}
		}
		return result;
	}


}