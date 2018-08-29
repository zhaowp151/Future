/**   
 * Copyright © 2018 
 * 
 * @Title: StringUtil.java 
 * @Prject: Future
 * @Package: com.future.core.util 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月29日 下午3:51:24 
 * @version: V1.0   
 */
package com.future.core.util;

/** 
 * @ClassName: StringUtil 
 * @Description: 字符串处理
 * @author: zhaowp
 * @date: 2018年8月29日 下午3:51:24  
 */
public class StringUtil {
	//首字符大写
	public static String upperCase(String str) {
	    char[] ch = str.toCharArray();
	    if (ch[0] >= 'a' && ch[0] <= 'z') {
	        ch[0] = (char) (ch[0] - 32);
	    }
	    return new String(ch);
	}
	//首字符小写
	public static String lowerCase(String str) {
	    char[] ch = str.toCharArray();
	    if (ch[0] >= 'A' && ch[0] <= 'Z') {
	        ch[0] = (char) (ch[0] + 32);
	    }
	    return new String(ch);
	}
}
