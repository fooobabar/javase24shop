package com.doit.shop.Test;

import org.junit.Test;

import com.doit.shop.user.dao.UserDao;
import com.doit.shop.user.dao.UserDaoImpl;
import com.doit.shop.user.service.User;

public class TestUser {
	
	@Test
	public void TestAddUser() throws Exception{
		UserDao udi = new UserDaoImpl();
		User user = new User("u01","123","张三",18,4,"18877776666","北京");
		udi.addUser(user); 
		
		System.out.println(udi.checkUserIfExistsById(user.getAccount()));
		
		User user2=udi.getUserByAccount(user.getAccount());
		System.out.println(user2);
		udi.removeUser(user.getAccount());
		System.out.println(udi.checkUserIfExistsById(user.getAccount()));
	}
}
