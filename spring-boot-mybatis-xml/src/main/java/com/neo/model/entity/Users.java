package com.neo.model.entity;

import java.io.Serializable;

import com.neo.enums.UserSexEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String passWord;
	private UserSexEnum userSex;
	private String nickName;


	public Users(String userName, String passWord, UserSexEnum userSex) {
		super();
		this.passWord = passWord;
		this.userName = userName;
		this.userSex = userSex;
		this.id = id;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "userName： " + this.userName + ", pasword： " + this.passWord + "sex： " + userSex.name();
	}

}