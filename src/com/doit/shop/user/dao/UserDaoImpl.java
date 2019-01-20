package com.doit.shop.user.dao;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.util.HashMap;
import java.util.List;

import com.doit.shop.user.service.User;
import com.doit.show.constant.DataBasePathConstant;

public class UserDaoImpl implements UserDao {
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeUser(String account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserByAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserByAgeRange(int maxAge, int minAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserByVipRange(int maxVip, int minVip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
