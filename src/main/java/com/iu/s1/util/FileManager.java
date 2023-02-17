package com.iu.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	//FILE�� HDD�� ����
	public String fileSave(MultipartFile multipartFile, String path) throws Exception{
		//			1. ��� �����Ұ��ΰ�?
		//			/resources/upload/bankbook/...
		//			2. ��������� �ü�� ���
		File file = new File(path);
		//������ �������� ������ ���� ����.
		if(!file.exists()) {
			file.mkdirs();
		}
		//			3. make fileName
		//			�ߺ����� �ʴ� ���ϸ� ����
//		Calendar ca = Calendar.getInstance();
//		Long a = ca.getTimeInMillis();
		
		String name= UUID.randomUUID().toString();
		
		//			4. Ȯ���� �߰�
		//originalName + subString�� �̿��Ͽ� Ȯ���� ����
		
		//name + originalName 
		name= name+"_"+multipartFile.getOriginalFilename();
		System.out.println(name);
		
		//			5. file save
		file = new File(file, name);
		
		//1) multifile ��ü�� transferTo �޼��� ���
//		multipartFile.transferTo(file);
		
		//2)Sping API FileCopyUtis ��ü�� copy�޼��� ���(staticmethod)
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		return name;
	}
}