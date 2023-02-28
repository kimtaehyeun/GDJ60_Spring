package com.iu.s1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.s1.board.BoardFileDTO;

@Component("fileDownView")
public class FileDownView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("filedownview");
		
//		 Iterator<String> it=model.keySet().iterator();
//		 while(it.hasNext()) {
//			 String key = it.next();
//			 System.out.println("key = "+key);
//			 
//		 }
		//필요한 키
		//key : boardName, boardFile
		
		//1. 어느경로에 파일명이 뭔지 알아야함.
		BoardFileDTO boardFileDTO =  (BoardFileDTO)model.get("boardFile");
		String path = (String)model.get("boardName");
		path = "resources/upload/"+path+"/";
		//session은 request객체에서꺼냄(오버라이딩이기때문에 session을 매개변수로 받지 못함)
		path =  request.getSession().getServletContext().getRealPath(path);
		
		//2.파일 받기
		File file = new File(path, boardFileDTO.getFileName());//경로 및 객체 넣은 파일 생성
		
		//#응답시 한글 Encoding 처리
		response.setCharacterEncoding("UTF-8");
		//	-> web.xml에 filter로 설정해 놓긴 했음
		
		//3.파일의 크기 찾기
		response.setContentLength((int)file.length());
		
		//4. 다운시 파일 네이밍 처리
		String downName = boardFileDTO.getOriName();
		downName = URLEncoder.encode(downName, "UTF-8");
		
		//5. header정보 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+downName+"\"");//다운로드할 파일 이름에 ""붙여줘야함
		response.setHeader("Contents-Transfer-Encoding", "binary");//2진(binary)
		
		//6. 전송
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();//ip알아오기
		
		FileCopyUtils.copy(fi, os);
		
		//7. 자원해제
		os.close();
		fi.close();
		
		
	}

}
