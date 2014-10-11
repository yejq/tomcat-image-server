package com.yejq.images;

import org.junit.Test;

public class ResourceUtilTest {

	@Test
	public void getStringTest(){
		System.out.println(ResourceUtil.getString("images_path"));
	}
}
