package com.iu.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	//FILE을 HDD에 저장
	public String fileSave(MultipartFile multipartFile, String path) throws Exception{
		//			1. 어디에 저장할것인가?
		//			/resources/upload/bankbook/...
		//			2. 저장관리는 운영체제 담당
		File file = new File(path);
		//폴더가 존재하지 않으면 폴더 생성.
		if(!file.exists()) {
			file.mkdirs();
		}
		//			3. make fileName
		//			중복되지 않는 파일명 생성
//		Calendar ca = Calendar.getInstance();
//		Long a = ca.getTimeInMillis();
		
		String name= UUID.randomUUID().toString();
		
		//			4. 확장자 추가
		//originalName + subString을 이용하여 확장자 추출
		
		//name + originalName 
		name= name+"_"+multipartFile.getOriginalFilename();
		System.out.println(name);
		
		//			5. file save
		file = new File(file, name);
		
		//1) multifile 객체의 transferTo 메서드 사용
//		multipartFile.transferTo(file);
		
		//2)Sping API FileCopyUtis 객체의 copy메서드 사용(staticmethod)
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		return name;
	}
}
