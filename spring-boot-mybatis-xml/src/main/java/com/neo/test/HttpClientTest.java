package com.neo.test;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.neo.util.HttpClientResult;
import com.neo.util.HttpClientUtils;
import com.neo.util.WXUtil;

/*************************
* @ClassName: HttpClientTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author: huhao
* @date 2019年12月23日 上午10:49:39
*
**************************/
public class HttpClientTest {

	private static String url = "http://127.0.0.1:9902/viagogo/mybatis/";

	private static String getAll_value = "getUsers";
	
	private static final String getByUserId = "getUser";
	
	private static final String addUsers = "add";
	
	private static final String deleteUsers = "delete/";
	
	private static final String deleteAll = "deleteAll";
	
	private static final String getWXToken = "getWxToken";
	
	private static final String addWXTag= "tag/addTag";
	
	private static final String getWXAllTag= "tag/getAllTag";

	public static void main(String[] args) throws Exception {
//		getAllTest();
//		getTest();
//		saveTest();
//		deleteTest();
//		deleteAllTest();
		HttpClientResult httpClientResult = getWXTokenTest();
		if (200 == httpClientResult.getStatusCode()) {
			JSONObject jsonObject = JSONObject.parseObject((String)httpClientResult.getContent());
			String token = jsonObject.getString("content");
//			getAllTag(token);		
			addTagTest(token);
		}
	}

	/**
	* @Title: getWXTokenTest
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @throws
	 */
	public static HttpClientResult getWXTokenTest() throws Exception{
		HttpClientResult httpClientResult =  HttpClientUtils.doGet(url+getWXToken,false);
		System.out.println(httpClientResult.getStatusCode());
		System.out.println(httpClientResult.getContent());
		return httpClientResult;
	}
	
	/**
	 * 
	 * @Title: getTest @Description: test getAll @param @throws Exception
	 * 设定文件 @return void 返回类型 @throws
	 */
	public static void getAllTest() throws Exception {
		HttpClientResult httpClientResult =   HttpClientUtils.doGet(url + getAll_value,false);
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
		
		HttpClientResult httpClientResult =HttpClientUtils.doGet(url+getByUserId, paramMap,false);
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
		HttpClientResult httpClientResult = HttpClientUtils.doPost(url+addUsers, userMap,false);
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
		HttpClientResult httpClientResult = HttpClientUtils.doPost(url+deleteUsers+deleteMap.get("id"),deleteMap,false);
		
		if (200 == httpClientResult.getStatusCode()) {
			System.out.println(httpClientResult.getContent());
			System.out.println(httpClientResult.getContent().toString());
		}
	}
	
	public static void deleteAllTest() throws Exception {		
		HttpClientResult httpClientResult =   HttpClientUtils.doPost(url+deleteAll,false);
		if (200 == httpClientResult.getStatusCode()) {
			System.out.println(httpClientResult.getStatusCode());
			System.out.println("deleteAll success");
		}
	}
	
	public static void addTagTest(String token) throws Exception {
		Map<String, String> paraMap = new HashMap<String, String>();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "ddd");
		
		paraMap.put("tag", jsonObject.toJSONString());
		paraMap.put("access_token", token);
		
		HttpClientResult httpClientResult = HttpClientUtils.doPost(url+addWXTag, paraMap, false);
		System.out.println("返回编码："+httpClientResult.getStatusCode());
		System.out.println("返回数据："+httpClientResult.getContent());
	}
	
	public static void getAllTag(String token) throws Exception {
		Map<String, String> paraMap = new HashMap<String, String>();
		paraMap.put("access_token", token);
		HttpClientResult httpClientResult = HttpClientUtils.doGet(url+getWXAllTag, paraMap,false);
		System.out.println("返回编码："+httpClientResult.getStatusCode());
		System.out.println("返回数据："+httpClientResult.getContent());
	}
}
