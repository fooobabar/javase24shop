package com.doit.shop.user.dao;

import java.util.List;

import com.doit.shop.user.service.User;

public interface UserDao {

	/**
	 * 增 往数据库增加一个用户
	 */
	
	public boolean addUser(User user);
	
	/**
	 * 移除一个用户
	 */
	public boolean removeUser(String account);
	
	/**
	 * 修改用户：要求service层把要修改的用户的所有数据全传过来
	 */
	public boolean updateUser(User user);
	
	/**
	 * 查，根据账号查询用户
	 */
	public User getUserByAccount(String account);
	
	/**
	 * 查，根据年龄范围查询用户
	 * @param maxAge 最大年龄
	 * @param minAge 最小年龄
	 * @return 用户List
	 */
	public List<User> getUserByAgeRange(int maxAge,int minAge);
	
	/**
	 * 根据vip等级范围查询用户
	 * @param maxVip 最大vip等级
	 * @param minVip 最小vip等级
	 */
	public List<User> getUserByVipRange(int maxVip,int minVip);
	
	/**
	 * 根据名字查询用户
	 * @param name 传入name
	 * @return 返回用户列表
	 */
	public List<User> getUserByName(String name);
}
