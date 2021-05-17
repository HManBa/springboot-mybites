package com.neo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.mapper.UserMapper;
import com.neo.model.entity.Users;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {


	
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/getUsers")
	public List<Users> getUsers() {
		List<Users> users = userMapper.getAll();
		return users;
	}

	@RequestMapping("/getUser")
	public Users getUser(Long id) {
		Users user = userMapper.getOne(id);
		return user;
	}

	@RequestMapping("/add")
	public void save(Users user) {
		userMapper.insert(user);
	}

	@RequestMapping(value = "update")
	public void update(Users user) {
		userMapper.update(user);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		userMapper.delete(id);
	}

	@RequestMapping(value = "/deleteAll")
	public void deleteAll() {
		userMapper.deleteAll();
	}

	@PostMapping(value = "/postGetUser")
	public Users postGetUser(@PathVariable("id") Long id) {
		return userMapper.getOne(id);
	}
	
	@PostMapping(value = "/postGetAll")
	public List<Users> postGetAll(){
		return userMapper.getAll();
	}
	
	@PostMapping("/postDelete")
	public void postDelete(@PathVariable("id") Long id) {
		userMapper.delete(id);
	}
}