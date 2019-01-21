package com.doit.shop.user.dao;

import java.io.File;	
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.doit.shop.constant.DataBasePathConstant;
import com.doit.shop.user.service.User;
import com.doit.shop.util.FileOperateUtil;

public class UserDaoImpl implements UserDao {
	
	FileOperateUtil<User> util = new FileOperateUtil<User>();
	
	@Override
	public boolean addUser(User user) throws Exception {
		HashMap<String, User> userMap = new HashMap<>();
		userMap.put(user.getAccount(), user);
		
		if(this.checkUserIfExistsById(user.getAccount())){
			return false;
		}
		util.writeToDB(DataBasePathConstant.USER_DATA_PATH, userMap); 
		return this.checkUserIfExistsById(user.getAccount());
	}

	@Override
	public boolean removeUser(String account) throws Exception { 
		File file = new File(DataBasePathConstant.USER_DATA_PATH);
		if(!file.exists()){
			return false;
		}
		
		HashMap<String,User> userMap=util.readFromDB(DataBasePathConstant.USER_DATA_PATH);

		userMap.remove(account);
		
		return this.checkUserIfExistsById(account);
		
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		HashMap<String, User> userMap = util.readFromDB(DataBasePathConstant.USER_DATA_PATH);
		
		userMap.put(user.getAccount(), user);
		
		util.writeToDB(DataBasePathConstant.USER_DATA_PATH, userMap);

		return checkUserIfExistsById(user.getAccount());
	}

	@Override
	public User getUserByAccount(String account) throws Exception {
		File file = new File(DataBasePathConstant.USER_DATA_PATH);
		if (file.exists()){
			
			HashMap<String, User> userMap = util.readFromDB(DataBasePathConstant.USER_DATA_PATH);

			return userMap.get(account);
		} 
		return null;
	}

	@Override
	public List<User> getUserByAgeRange(int maxAge, int minAge) throws Exception {
		HashMap<String, User> userMap = util.readFromDB(DataBasePathConstant.USER_DATA_PATH);
		ArrayList<User> uList = new ArrayList<User>();
		
		Collection<User> values = userMap.values();
		
		for (User user : values) {
			if(user.getAge() >= minAge && user.getAge() <= maxAge){
				uList.add(user);
			}
		}
		
		return uList;
	}

	@Override
	public List<User> getUserByVipRange(int maxVip, int minVip) throws Exception {
		HashMap<String, User> userMap=util.readFromDB(DataBasePathConstant.USER_DATA_PATH);
		ArrayList<User> uList = new ArrayList<>();
		Collection<User> values = userMap.values();
		for (User user : values) {
			if(user.getVipLevel() >= minVip && user.getVipLevel() <= maxVip){
				uList.add(user);
			}
		}
		return uList;
	}

	@Override
	public List<User> getUserByName(String name) throws Exception {
		HashMap<String, User> userMap=util.readFromDB(DataBasePathConstant.USER_DATA_PATH);
		ArrayList<User> uList = new ArrayList<>();
		Collection<User> values = userMap.values();
		for (User user : values) {
			if(user.getName()== name){
				uList.add(user);
			}
		}
		return uList;
	}
 
	@Override
	public boolean checkUserIfExistsById(String account) throws Exception {
		
		File file = new File(DataBasePathConstant.USER_DATA_PATH);
		if (file.exists()){
			HashMap<String, User> userMap = util.readFromDB(DataBasePathConstant.USER_DATA_PATH);
			return userMap.containsKey(account);
		}
		return false;
	}

}
