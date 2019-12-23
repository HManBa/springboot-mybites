package com.neo.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neo.util.HttpClientResult;
import com.neo.util.HttpClientUtils;

/*************************
* @ClassName: WXTokenTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author: huhao
* @date 2019年12月23日 上午10:35:00
*
**************************/
@RunWith(SpringRunner.class)
@SpringBootTest
public class WXTokenControllerTest {

	@Value("url.WXToken")
	String wx_tokenUrl;
	@Test
	public void testWXTokenTest() throws Exception {
		HttpClientResult httpClientResult =  HttpClientUtils.doGet("http://127.0.0.1:9902/viagogo/mybatis/getWxToken");
		System.out.println(httpClientResult.getStatusCode());
		System.out.println(httpClientResult.getContent());
	}
}
