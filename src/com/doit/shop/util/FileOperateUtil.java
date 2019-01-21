package com.doit.shop.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.doit.shop.constant.DataBasePathConstant;

public class FileOperateUtil<T> {
	public HashMap<String, T> readFromDB(String dbpath) throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dbpath));
		
		HashMap<String, T> objMap = (HashMap<String, T>)ois.readObject();
		ois.close();
		return objMap;
	}
	
	public void writeToDB(String dbpath,HashMap<String, T> objMap) throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbpath));
		
		oos.writeObject(objMap);
		
		oos.close();
		
	}
}
