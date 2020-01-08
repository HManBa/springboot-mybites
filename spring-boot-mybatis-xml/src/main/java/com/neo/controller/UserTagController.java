package com.neo.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/*************************
* @ClassName: UserTagController
* @Description: 标签管理
* @author: huhao
* @date 2019年12月24日 上午9:21:59
*
**************************/
@Slf4j
@RestController
public class UserTagController {

	public void GetUserInfo0(@RequestParam(value = " password") String value ) {
		
		
		try {
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
