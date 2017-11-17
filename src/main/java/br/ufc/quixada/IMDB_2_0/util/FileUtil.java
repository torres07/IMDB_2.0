package br.ufc.quixada.IMDB_2_0.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static void imageSave(String path, MultipartFile image){
		File file = new File(path);
		
		try {
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
