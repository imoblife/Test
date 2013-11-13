package com.example.test.m;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyModel {
	private static String buffer = "";

	public static String get() {
		return buffer;
	}

	public static void add(String buffer) {
		MyModel.buffer += getTime() + "\n" + buffer + "\n";
	}

	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		return sdf.format(new Date(System.currentTimeMillis()));
	}
}
