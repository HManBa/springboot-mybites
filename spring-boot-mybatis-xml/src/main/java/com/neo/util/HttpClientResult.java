package com.neo.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
