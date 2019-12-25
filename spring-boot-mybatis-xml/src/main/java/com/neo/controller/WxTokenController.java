package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.neo.model.entity.ReturnDto;
import com.neo.util.HttpClientResult;
import com.neo.util.ReturnDtoUtil;
import com.neo.util.WXUtil;

/*************************
 * @ClassName: WxToken
 * @Description: 微信token
 * @author: huhao
 * @date 2019年12月23日 上午10:02:18
 *
 **************************/
@RestController
public class WxTokenController {
	
	@Autowired
	private WXUtil wxTokenUtil;

	@RequestMapping("/getWxToken")
	public ReturnDto getWxToken() {
		HttpClientResult httpClientResult = wxTokenUtil.getWxToken();
		JSONObject jsonObject = JSONObject.parseObject((String) httpClientResult.getContent());
		
		if (200 == httpClientResult.getStatusCode() &&StringUtils.isEmpty(jsonObject.getString("errcode"))) {
			return ReturnDtoUtil.success(jsonObject.get("access_token"));
		}
		
		return ReturnDtoUtil.fail(jsonObject.getString("errcode"), jsonObject.get("errmsg"));
	}
}
