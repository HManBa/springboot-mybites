package com.neo.util;

import com.neo.enums.ReturnEnum;
import com.neo.model.entity.ReturnDto;

/*************************
* @ClassName: ReturnDtoUtil
* @Description: 返回请求结果工具类
* @author: huhao
* @date 2019年12月23日 上午10:20:48
*
**************************/
public class ReturnDtoUtil {

	public static ReturnDto success(Object content) {
		return new ReturnDto(ReturnEnum.OK.getCode(), "", content);
	}
	
	public static ReturnDto fail(String error,Object content) {
		return new ReturnDto(ReturnEnum.FAIL.getCode(), error, content);
	}
}
