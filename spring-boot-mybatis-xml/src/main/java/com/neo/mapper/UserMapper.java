package com.neo.mapper;

import java.util.List;

import com.neo.model.entity.Users;

public interface UserMapper {
	
	List<Users> getAll();
	
	Users getOne(Long id);

	void insert(Users user);

	void update(Users user);

	void delete(Long id);

}