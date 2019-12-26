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
}
