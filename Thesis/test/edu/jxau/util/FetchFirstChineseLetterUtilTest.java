package edu.jxau.util;

import org.junit.Test;

public class FetchFirstChineseLetterUtilTest {

	@Test
	public void testGetFirstLetter() {
		System.out.print(FetchFirstChineseLetterUtil
				.getFirstLetter("软件1202班"));// 获取文字首字母的拼音
	}
	
	@Test
	public void testConvert() {
		String serial = "0001";
		System.out.println(Integer.parseInt(serial));
	}

}
