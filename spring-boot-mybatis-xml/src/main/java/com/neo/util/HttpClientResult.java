package com.neo.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*************************
* @ClassName: HttpClientResult
* @Description: 请求http返回结果集
* @author: huhao
* @date 2019年12月20日 上午10:44:26
*
**************************/
@AllArgsConstructor
@Getter
@Setter
public class HttpClientResult {

	public HttpClientResult(int scInternalServerError) {
		this.statusCode = scInternalServerError;
	}

	private int statusCode;
	
	private Object content;
	
}
