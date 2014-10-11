package com.yejq.images;

import java.util.ResourceBundle;

public class ResourceUtil {

	
	private static class ResourceHolder{
		static ResourceBundle instance = ResourceBundle.getBundle("config");
	}
	
	public static String getString(String key){
		return ResourceHolder.instance.getString(key);
	}
	
}
