package com.user.UserInfo.Service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.UserInfo.Dao.*;
import com.user.UserInfo.Entity.UserProfile;

@Service
public class userService {
	 @Autowired
	  private userDao userDao ;
		  
	  public void insertUser(UserProfile user) {
		  this.userDao.insertUser(user);
	  }
	  
	  public void insertArrayUser(List<UserProfile> user) {
		  this.userDao.insertArrayUser(user);
	  }
	  
	  public UserProfile getUser(String user) {
		  return this.userDao.getUser(user);
	  }
	  
	  public List<UserProfile> getAllUser(){
		  return this.userDao.getAllUsers();
	  }
	  
	  public List<UserProfile> getUserByDetails(String name, int userStatus){
		  return this.userDao.getUserByDetails( name,  userStatus);
	  }
	  
	  public void updateUser(String paramUserName,UserProfile user) {
		  this.userDao.updateUser(paramUserName,user);
	  }
	  
	  public void deleteUser(String paramUserName) {
		  this.userDao.deleteUser(paramUserName);
	  }
}
