package com.iu.s1.bankbook;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class BankBookService {
	@Autowired
	private BankBookDAO bankBookDAO;
	@Autowired
	private FileManager fileManager;
	
	//testCase 테스트시 null이 들어옴
	//test하려면 api추가해야함. = > test할땐 톰캣을 실행 안시키기 떄문
	@Autowired
	private ServletContext servletContext;
	
	public List<BankBookDTO> getBankBookList(Pager pager)throws Exception{
		Long totalCount= bankBookDAO.getBankBookCount(pager);
		
		pager.makeRow();
		pager.makeNum(totalCount);
		return bankBookDAO.getBankBookList(pager);	
	}
	
	public BankBookDTO getBankBookDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getBankBookDetail(bankBookDTO);
		
	}
	public int setBankBookAdd(BankBookDTO bankBookDTO, MultipartFile pic) throws Exception{
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		//1. file을 hdd에 저장
		// project 경로가 아닌 OS가 이용하는 경로
		String realPath=servletContext.getRealPath("resources/upload/bankBook");
		System.out.println(realPath);
		String fileName =fileManager.fileSave(pic, realPath);
		
		//2. db에 저장
		BankBookImgDTO bankBookimgDTO = new BankBookImgDTO();
		bankBookimgDTO.setFileName(fileName);
		bankBookimgDTO.setOriName(pic.getOriginalFilename());
		bankBookimgDTO.setBookNumber(bankBookDTO.getBookNumber());
//		return bankBookDAO.setBankBookAdd(bankBookDTO);
		result = bankBookDAO.setBankBookImgAdd(bankBookimgDTO);
		return result;
	}
	public int setBankBookDelete(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.setBankBookDelete(bankBookDTO);
		
	}
	public int setBankBookUpdate(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.setBankBookUpdate(bankBookDTO);
	}
}
