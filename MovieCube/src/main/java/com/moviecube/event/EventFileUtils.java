package com.moviecube.event;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.moviecube.common.CommonUtils;

@Component("eventFileUtils")
public class EventFileUtils {
	private static final String filePath = "C:\\java\\maven\\MovieCube\\src\\main\\webapp\\resources\\upload\\event\\"; 
																											

	public List<Map<String, Object>> parseInsertFileInfo(Map<String, Object> map, HttpServletRequest request)
			throws Exception {
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;

		List<Map<String, Object>> Filelist = new ArrayList<Map<String, Object>>(); 
		Map<String, Object> FilelistMap = null;

		int EVENT_NO = (int) map.get("EVENT_NO"); 

		File file = new File(filePath); 
		if (file.exists() == false) {
			file.mkdirs();
		}

		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			System.out.println("test ============================== " + multipartFile.getName());

			if (multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = CommonUtils.getRandomString() + originalFileExtension; 

				file = new File(filePath + storedFileName); 
				multipartFile.transferTo(file); 

				FilelistMap = new HashMap<String, Object>();
				FilelistMap.put("EVENT_NO", EVENT_NO);
				FilelistMap.put("EVENT_ORGNAME", originalFileName);
				FilelistMap.put("EVENT_SAVNAME", storedFileName);
				Filelist.add(FilelistMap);
			}

		}

		return Filelist;

	}

	public List<Map<String, Object>> parseUpdateFileInfo(Map<String, Object> map, HttpServletRequest request)
			throws Exception {
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;

		List<Map<String, Object>> Filelist = new ArrayList<Map<String, Object>>();
		Map<String, Object> FilelistMap = null;

		int EVENT_NO = Integer.parseInt((String)map.get("EVENT_NO"));
		
		String requestName = null;
		String idx = null;

		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			System.out.println("test ============================== " + multipartFile.getName());

			if (multipartFile.isEmpty() == false) {
				/*
				 * if (multipartFile.isEmpty() == false &&
				 * multipartFile.getName().equals("EVENT_ORGNAME")) {
				 */
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = CommonUtils.getRandomString() + originalFileExtension;

				multipartFile.transferTo(new File(filePath + storedFileName));

				FilelistMap = new HashMap<String, Object>();
				FilelistMap.put("IS_NEW", "Y");
				FilelistMap.put("EVENT_NO", EVENT_NO);
				FilelistMap.put("EVENT_ORGNAME", originalFileName);
				FilelistMap.put("EVENT_SAVNAME", storedFileName);
				Filelist.add(FilelistMap);
			} else {
				requestName = multipartFile.getName();
				idx = "IDX_" + requestName.substring(requestName.indexOf("_") + 1);

				FilelistMap = new HashMap<String, Object>();
				FilelistMap.put("IS_NEW", "N");
				FilelistMap.put("FILE_NO", map.get(idx));
				Filelist.add(FilelistMap);
			}
		}

		return Filelist;
	}
	
	public void fileDelete(Map<String, Object> map, String filePath, String media) throws Exception{
	String EVENT_SAVNAME = null;
	File file = null;
	
	file = new File(filePath + EVENT_SAVNAME);
	file.delete();

}
}
