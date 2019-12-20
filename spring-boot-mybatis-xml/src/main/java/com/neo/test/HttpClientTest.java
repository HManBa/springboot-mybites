package com.neo.test;

import java.util.HashMap;
import java.util.Map;

import com.neo.util.HttpClientResult;
import com.neo.util.HttpClientUtils;

public class HttpClientTest {

	private static String url = "http://127.0.0.1:9902/viagogo/mybatis/";

	private static String getAll_value = "getUsers";
	
	private static final String getByUserId = "getUser";
	
	private static final String addUsers = "add";
	
	private static final String deleteUsers = "delete/";
	
	private static final String deleteAll = "deleteAll";

	public static void main(String[] args) throws Exception {
//		getAllTest();
//		getTest();
//		saveTest();
//		deleteTest();
		deleteAllTest();
	}

	/**
	 * 
	 * @Title: getTest @Description: test getAll @param @throws Exception
	 * 设定文件 @return void 返回类型 @throws
	 */
	public static void getAllTest() throws Exception {
		HttpClientResult httpClientResult =   HttpClientUtils.doGet(url + getAll_value);
		if (200 == httpClientResult.getStatusCode()) {
			Object userList = httpClientResult.getContent();
			System.out.println(userList.toString());
		}
	}

	/**
	 * 
	 * @Title: getTest @Description: test getTest @param @throws Exception
	 * 设定文件 @return void 返回类型 @throws
	 */
	public static void getTest() throws Exception {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", "4");
		
		HttpClientResult httpClientResult =HttpClientUtils.doGet(url+getByUserId, paramMap);
		if (200 == httpClientResult.getStatusCode()) {
			Object userList = httpClientResult.getContent();
			System.out.println(userList.toString());
		}
	}

	/**
	 * 
	* @Title: saveTest
	* @Description: 测试保存功能
	* @param @throws Exception    设定文件
	* @return void    返回类型
	* @throws
	 */
	public static void saveTest() throws Exception {
		HashMap<String, String> userMap = new HashMap<String, String>();
		userMap.put("userName", "jack");
		userMap.put("passWord", "123456");
		HttpClientResult httpClientResult = HttpClientUtils.doPost(url+addUsers, userMap);
		if (200 == httpClientResult.getStatusCode()) {
			System.out.println("return saveTest code:: "+httpClientResult.getStatusCode());
			System.out.println(httpClientResult.getContent().toString());
		}
	}
	
	/**
	 * 
	* @Title: deleteTest
	* @Description: 测试delete方法
	* @param @throws Exception    设定文件
	* @return void    返回类型
	* @throws
	 */
	public static void deleteTest() throws Exception {
		Map<String, String> deleteMap = new HashMap<String, String>();
		deleteMap.put("id", "40");
		HttpClientResult httpClientResult = HttpClientUtils.doPost(url+deleteUsers+deleteMap.get("id"),deleteMap);
		
		if (200 == httpClientResult.getStatusCode()) {
			System.out.println(httpClientResult.getContent());
			System.out.println(httpClientResult.getContent().toString());
		}
	}
	
	public static void deleteAllTest() throws Exception {
		Map<String, String> deleteMap = new HashMap<String, String>();
		deleteMap.put("id", "28");
		
		HttpClientResult httpClientResult =   HttpClientUtils.doPost(url+deleteAll);
		if (200 == httpClientResult.getStatusCode()) {
			System.out.println(httpClientResult.getStatusCode());
			System.out.println("deleteAll success");
		}
	}
}
