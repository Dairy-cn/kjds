package com.cross.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/*************************************************************
 * Description: 
 * Author: Dair
 * CreateTime: 2020/5/18
 ************************************************************/
public class PinyinUtil {
	
	/**
	 * 得到首字母
	 *
	 * @param str
	 * @return
	 */
	public static  String getPinYinHeadChar(String str) {
		String convert = "";
		if (StringUtils.isNotEmpty(str)) {
			char word = str.charAt(0);
			//提取汉字的首字母
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (Objects.nonNull(pinyinArray)) {
				convert += pinyinArray[0].charAt(0);
			}
		}
		return convert.toUpperCase();
	}
	
}
