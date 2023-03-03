package com.iu.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.util.Pager;
@Service
public class BankBookCommentService implements BbsService {
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;

	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
		
		Long result =bankBookCommentDAO.getTotalCount(pager);
		pager.makeNum(result);
		
		return bankBookCommentDAO.getBoardList(pager);
	}

	

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		return bankBookCommentDAO.setBoardAdd(bbsDTO);
	}



	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}







	
	
}
