package com.baizhi.cmfz.utils;

import java.util.Random;

public class EncrypteUtils {
	/**
	 * ��ȡ�����˽��
	 * @return String
	 */
	public static String getSalt(int num){
		String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRDTUVWXYZ"; 
		char[] chs = s.toCharArray();
		StringBuilder builder = new StringBuilder();
		Random rm = new Random();
		for (int i = 0; i < num; i++) {
			builder.append(chs[rm.nextInt(chs.length)]);
		}
		return builder.toString();
	}

}
