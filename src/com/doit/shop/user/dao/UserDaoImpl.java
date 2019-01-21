package com.doit.shop.user.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.DatabaseMetaData;
import java.util.HashMap;
import java.util.List;

import com.doit.shop.constant.DataBasePathConstant;
import com.doit.shop.user.service.User;

public class UserDaoImpl implements UserDao {
	
	
	@Override
	public boolean addUser(User user) throws Exception {
		HashMap<String, User> userMap = new HashMap<>();
		File file = new File(DataBasePathConstant.USER_DATA_PATH);
		if(file.exists() && !this.checkUserIfExistsById(user.getAccount())){
			userMap.put(user.getAccount(), user);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DataBasePathConstant.USER_DATA_PATH));
			oos.writeObject(userMap);
			oos.close();
			
			return true;
		}else{
			userMap.put(user.getAccount(), user);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DataBasePathConstant.USER_DATA_PATH));
			oos.writeObject(userMap);
			oos.close();
		}
		return false;
	}

	@Override
	public boolean removeUser(String account) throws Exception { 
		File file = new File(DataBasePathConstant.USER_DATA_PATH);
		if(file.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DataBasePathConstant.USER_DATA_PATH));
			
			HashMap<String, User> userMap = (HashMap<String, User>)ois.readObject();
			ois.close();
			
			User user = userMap.remove(account);
			if(user != null){
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DataBasePathConstant.USER_DATA_PATH));
				oos.writeObject(userMap);
				oos.close();
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserByAccount(String account) throws Exception {
		File file = new File(DataBasePathConstant.USER_DATA_PATH);
		if (file.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DataBasePathConstant.USER_DATA_PATH));
			
			HashMap<String, User> userMap = (HashMap<String, User>)ois.readObject();
			ois.close();
			return userMap.get(account);
		} 
		return null;
	}

	@Override
	public List<User> getUserByAgeRange(int maxAge, int minAge) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DataBasePathConstant.USER_DATA_PATH));
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
 
	@Override
	public boolean checkUserIfExistsById(String account) throws Exception {
		
		File file = new File(DataBasePathConstant.USER_DATA_PATH);
		if (file.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DataBasePathConstant.USER_DATA_PATH));
			
			HashMap<String, User> userMap = (HashMap<String, User>)ois.readObject();
			ois.close();
			return userMap.containsKey(account);
		}
		return false;
	}

}
