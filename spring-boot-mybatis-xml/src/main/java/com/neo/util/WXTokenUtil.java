package com.neo.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WXTokenUtil {
	
	private static final String APPID = "";
	
	private static final String SECRET = "";
	
	@Value("${url.WXToken}")
    private  String url;
	
	public HttpClientResult getWxToken()  {
		try {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("grant_type", "client_credential");
			paramMap.put("appid",APPID );
			paramMap.put("secret", SECRET);
			
			System.out.println(url);
			return HttpClientUtils.doGet(url,paramMap);
		} catch (Exception e) {
			log.info("获取微信token错误："+e.getMessage());
			return new HttpClientResult(100, "获取错误");			
		}
	}
	

}
