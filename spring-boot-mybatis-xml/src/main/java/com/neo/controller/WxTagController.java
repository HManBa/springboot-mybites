package com.neo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.util.StringUtils;
import com.neo.enums.ReturnEnum;
import com.neo.model.entity.ReturnDto;
import com.neo.util.HttpClientResult;
import com.neo.util.ReturnDtoUtil;
import com.neo.util.WXUtil;

import lombok.extern.slf4j.Slf4j;

/*************************
 * @ClassName: WxTagController
 * @Description: 微信标签
 * @author: huhao
 * @date 2019年12月24日 下午3:37:26
 *
 **************************/
@Slf4j
@RestController
@RequestMapping("/tag")
public class WxTagController {
	@Autowired
	private WXUtil WXUtil;

	@PostMapping("/addTag")
	public ReturnDto addTag(String access_token,@RequestParam (value = "tag")String tagJson) {
		ReturnDto returnDto;

		try {
			
			if (StringUtils.isNullOrEmpty(access_token) || tagJson == null || tagJson.isEmpty()) {
				return ReturnDtoUtil.fail(ReturnEnum.FAIL.getMessage(), "access_access_token或tag为空");
			}
			
			String param = "{ \"tag\" : { \"name\" : \"陕西\"}}";
			String Httpsreturn = httpsUtil(param, access_token);
			System.out.println(Httpsreturn);
				
			HttpClientResult httpClientResult = WXUtil.getWxUserTag(access_token,tagJson);
			
			if (200 == httpClientResult.getStatusCode()) {
				return ReturnDtoUtil.success(ReturnEnum.OK.getMessage());
			}

			returnDto = ReturnDtoUtil.fail(ReturnEnum.FAIL.getMessage(), null);
		} catch (Exception e) {
			log.error("添加微信标签错误：" + e.getMessage());
			returnDto = ReturnDtoUtil.fail(ReturnEnum.FAIL.getMessage(), null);
		}
		return returnDto;
	}
	
	@RequestMapping("/getAllTag")
	public ReturnDto getAllTag(String access_token) {
		ReturnDto returnDto;

		try {
			if (StringUtils.isNullOrEmpty(access_token)) {
				return ReturnDtoUtil.fail(ReturnEnum.FAIL.getMessage(), "access_access_token为空");
			}
			HttpClientResult httpClientResult = WXUtil.getWxAllTag(access_token);
			if (200 == httpClientResult.getStatusCode()) {
				return ReturnDtoUtil.success(ReturnEnum.OK.getMessage());
			}

			returnDto = ReturnDtoUtil.fail(ReturnEnum.FAIL.getMessage(), null);
		} catch (Exception e) {
			log.error("添加微信标签错误：" + e.getMessage());
			returnDto = ReturnDtoUtil.fail(ReturnEnum.FAIL.getMessage(), null);
		}
		return returnDto;
	}
	
	private static String httpsUtil(String param,String acces_token) throws IOException {
		URL url = new URL("https://api.weixin.qq.com/cgi-bin/tags/create?access_token="+acces_token);
		URLConnection connection = url.openConnection();
		 connection.setRequestProperty("accept", "*/*");
         connection.setRequestProperty("connection", "Keep-Alive");
         connection.setRequestProperty("Content-Type", "text/xml");
        // connection.setRequestProperty("Content-Length", body.getBytes().length+"");
         connection.setRequestProperty("User-Agent",
               "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
          
          
            connection.setDoOutput(true);  
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");  
            out.write(param); // 向页面传递数据。post的关键所在！  
            out.flush();  
            out.close();  
            // 一旦发送成功，用以下方法就可以得到服务器的回应：  
           
           String  sCurrentLine = "";  
           String  sTotalString = "";  
            InputStream l_urlStream;  
            l_urlStream = connection.getInputStream();  
            // 传说中的三层包装阿！  
            BufferedReader l_reader = new BufferedReader(new InputStreamReader(  
                    l_urlStream));  
            while ((sCurrentLine = l_reader.readLine()) != null) {  
                sTotalString += sCurrentLine + "\r\n";  
       
            }  
            
            return sTotalString;
	}
}
