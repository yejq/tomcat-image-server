package com.yejq.images;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImagesUtil {

	private static final String key_images_path = "images_path";

	public static boolean down(String destPath, String origUrl) {
		boolean isSuccess = false;
		OutputStream os = null;
		try {
			URL url = new URL(origUrl);
			InputStream is = url.openStream();
			os = new FileOutputStream(destPath);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return isSuccess;
	}

	public static String down(String origUrl) {
		String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ".jpg";
		String destPath = ResourceUtil.getString(key_images_path);
		File dir = new File(destPath);
		if (!dir.exists()) {
			dir.mkdir();
		}
		destPath += fileName;
		if (down(destPath, origUrl)) {
			return fileName;
		}else {
			return null;			
		}
	}
}
