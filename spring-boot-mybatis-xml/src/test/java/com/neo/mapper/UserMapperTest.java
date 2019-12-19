package com.neo.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neo.enums.UserSexEnum;
import com.neo.model.entity.Users;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() throws Exception {
		userMapper.insert(new Users("aa", "a123456", UserSexEnum.MAN));
		userMapper.insert(new Users("bb", "b123456", UserSexEnum.WOMAN));
		userMapper.insert(new Users("cc", "b123456", UserSexEnum.WOMAN));

		Assert.assertEquals(12, userMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<Users> users = userMapper.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users.toString());
		}
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		Users user = userMapper.getOne(28L);
		System.out.println(user.toString());
		user.setNickName("neo");
		userMapper.update(user);
		Assert.assertTrue(("neo".equals(userMapper.getOne(28L).getNickName())));
	}

}