package com.neo.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ReturnDto {

	private int code;

	private String error;

	private Object content;

	public ReturnDto(int code, Object content) {
		this.code = code;
		this.content = content;
	}

	public ReturnDto(int code, String error, Object content) {
		this.code = code;
		this.error = error;
		this.content = content;
	}

	public ReturnDto(int code, String error) {
		this.code = code;
		this.error = error;
	}
}
