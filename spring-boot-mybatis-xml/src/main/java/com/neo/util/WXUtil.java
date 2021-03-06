package com.neo.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

/*************************
* @ClassName: WXUtil
* @Description: 微信工具类
* @author: huhao
* @date 2019年12月24日 上午9:27:57
*
**************************/
@Slf4j
@Component
public class WXUtil {
	
	/*
	 * 微信appid
	 */
	@Value("${APPID}")
	private String appid;

	/**
	 * 微信secret
	 */
	@Value("${SECRET}")
	private String secret;

	/*
	 * 微信API获取token地址
	 */
	@Value("${url.WXToken}")
	private String url;
	
	/*
	 * 微信创建标签地址
	 */
	@Value("${url.createTag}")
	private String tagUrl;
	
	/*
	 * 微信获取公众号已创建的标签
	 */
	@Value("${url.getTag}")
	private String getTagUrl;
	
	/*
	 * 微信获取帐号的关注者列表
	 */
	@Value("${url.getUserOpenId}")
	private String getUserOpenIdUrl;
	
	/*
	 * 微信身份证OCR地址
	 */
	@Value("${url.identityCard}")
	private String identityCardUrl;
	
	/*
	 * 微信银行卡OCR地址
	 */
	@Value("${url.bankCard}")
	private String bankCardUrl;
	
	/**
	* 
	* @Title: getWxToken
	* @Description: 获取微信token
	* @param @return    设定文件
	* @return HttpClientResult    返回类型
	* @throws
	 */
	public HttpClientResult getWxToken() {
		try {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("grant_type", "client_credential");
			paramMap.put("appid", appid);
			paramMap.put("secret", secret);

			return HttpClientUtils.doGet(url, paramMap,false);
		} catch (Exception e) {
			log.info("获取微信token错误：" + e.getMessage());
			return new HttpClientResult(100, "获取错误");
		}
	}

	/**
	* 
	* @Title: getWxUserTag
	* @Description: 创建标签
	* @param @return    设定文件
	* @return HttpClientResult    返回类型
	* @throws
	 */
	public HttpClientResult getWxUserTag(String access_token,String tag) throws Exception {
		JSONObject jsonObject = new JSONObject();
		JSONObject nameObject = new JSONObject();
		nameObject.put("name", tag);
		jsonObject.put("tag", nameObject);
		
		return HttpClientUtils.doPost(tagUrl+access_token, null , true,jsonObject);
	}
	
	/**
	* 
	* @Title: getWxAllTag
	* @Description: 获取全部标签属性
	* @param @param access_token
	* @param @return
	* @param @throws Exception    设定文件
	* @return HttpClientResult    返回类型
	* @throws
	 */
	public HttpClientResult getWxAllTag(String access_token) throws Exception {		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("access_token", access_token);
		return HttpClientUtils.doGet(getTagUrl, paramMap,true);
	}
}
