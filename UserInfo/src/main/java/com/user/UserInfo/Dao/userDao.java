package com.user.UserInfo.Dao;

import com.user.UserInfo.Entity.UserProfile;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userDao  {
	 UserProfile getUser(String userName);
	 List<UserProfile> getAllUsers();
	 void insertUser(UserProfile user);	 
	 void insertArrayUser(List<UserProfile> user);
	 void updateUser(String paramUserName,UserProfile user);
	 void deleteUser(String paramUserName);
}
