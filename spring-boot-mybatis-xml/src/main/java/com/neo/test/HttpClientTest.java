package com.neo.test;

import java.util.HashMap;
import java.util.Map;

import com.neo.util.HttpClientUtils;

public class HttpClientTest {

	public static String url = "http://127.0.0.1:9902/viagogo/mybatis/";

	public static String get_value = "getUsers";

	public static void main(String[] args) throws Exception {
		getAllTest();
	}

	/**
	 * 
	 * @Title: getTest @Description: test getAll @param @throws Exception
	 * 设定文件 @return void 返回类型 @throws
	 */
	public static void getAllTest() throws Exception {
		System.out.println(HttpClientUtils.doGet(url + get_value));
	}

	/**
	 * 
	 * @Title: getTest @Description: test getTest @param @throws Exception
	 * 设定文件 @return void 返回类型 @throws
	 */
	public static void getTest() throws Exception {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", "28");
		System.out.println(HttpClientUtils.doGet(url, paramMap));
	}

	public static void postTest() throws Exception {

	}
}
