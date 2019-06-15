package com.wheeludrive.tools;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.wheeludrive.domain.PropertiesManager;

public class MediaManager {

	private final static Logger log = Logger.getLogger(MediaManager.class);

	private static int maxFileSize = 150 * 1024;
	private static int maxMemSize = 4 * 1024;

	private MediaManager() {
		// Utility Class
	}

	public static HttpServletRequest storeMediaFromRequest(HttpServletRequest request) throws Exception {

		PropertiesManager prop = new PropertiesManager();

		String folderRoot = prop.getFolderMedia();
		log.info("folderRoot =" + folderRoot);

		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFileSize);
		List<FileItem> fileItems = upload.parseRequest(request);

		for (FileItem item : fileItems) {

			if (!item.isFormField()) {

				String fileName = item.getName();
				if (fileName != null && !fileName.equals("")) {
					log.info("file name  =" + fileName);
					log.info("Location of the media should be " + folderRoot + File.separator + fileName);
					
					File file = new File(folderRoot + File.separator + fileName);
					if(!file.exists()) {
						item.write(file);
					}
					else {
						log.warn("The file "+file.getAbsolutePath()+ " already exists !!!");
					}
					request.setAttribute("file", fileName);
					log.debug(fileName + " DEBUG");
				}
			} else {
				log.debug("field: " + item.getFieldName() + "  value : " + item.getString());
				request.setAttribute(item.getFieldName(), item.getString());
			}
		}

		return request;
	}

	public static String encodeFileToBase64Binary(File file) throws IOException {

		byte[] fileContent = FileUtils.readFileToByteArray(file);
		String encodedString = Base64.getEncoder().encodeToString(fileContent);

		return encodedString;
	}

}
