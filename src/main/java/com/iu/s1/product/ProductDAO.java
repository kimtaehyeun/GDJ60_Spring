package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class ProductDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.product.ProductDAO.";
	
	//delete
	public int setProductDelete(Long productNum) throws Exception{
		return sqlSession.delete(NAMESPACE+"setProductDelete",productNum);
		
	}
	
	
	//getMax
	public Long getProductNum() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getProductNum");
	}


	public List<ProductDTO> getProductList()throws Exception{
		
		return sqlSession.selectList(NAMESPACE+"getProductList");
	}



	public int setProductAdd(ProductDTO productDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"setProductAdd",productDTO);
	}
	//-----------------------------------------
	//getproductDetail
	public ProductDTO getProductDetail(ProductDTO productDTO)throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getProductDetail", productDTO);
	}


	public List<ProductOptionDTO> getOptionList() throws Exception{
		
		ArrayList<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		Connection con = DBConnection.getConnection();
		String sql = "SELECT OPTIONNUM ,PRODUCTNUM ,OPTIONNAME ,OPTIONPRICE ,OPTIONJEGO  FROM PRODUCTOPTION";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			ProductOptionDTO dto = new ProductOptionDTO();
			dto.setOption_Num(rs.getLong("OPTIONNUM"));
			dto.setProduct_Num(rs.getLong("PRODUCTNUM"));
			dto.setOption_Name(rs.getString("OPTIONNAME"));
			dto.setOption_Price(rs.getInt("OPTIONPRICE"));
			dto.setOption_Jego(rs.getInt("OPTIONJEGO"));
			ar.add(dto);
		}
		return ar;
	}



	public int setAddoption(ProductOptionDTO optionDTO) throws Exception{
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCTOPTION VALUES "
				+ "(OPTION_SEQ.NEXTINT,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, optionDTO.getProduct_Num());
		st.setString(2, optionDTO.getOption_Name());
		st.setInt(3, optionDTO.getOption_Price());
		st.setInt(4, optionDTO.getOption_Jego());
		int result  = st.executeUpdate();
		DBConnection.disConnection(st, con);

		return result;
	}




	//test
	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		try {


		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
