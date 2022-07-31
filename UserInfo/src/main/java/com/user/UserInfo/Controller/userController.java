package com.user.UserInfo.Controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.user.UserInfo.Entity.Address;
import com.user.UserInfo.Entity.UserProfile;
import com.user.UserInfo.Service.*;


@RestController
@RequestMapping("/user")
public class userController {
	  @Autowired
	  private userService userService;
	  
	  @Autowired
	  private addressService addressService;

	  @PostMapping
	  public void insertUser(@Valid @RequestBody UserProfile user){
		  userService.insertUser(user);
	  }
	  	  
	  @PostMapping(value={"/createWithArray","/createWithList"})
	  public void insertUser(@Valid @RequestBody List<UserProfile> user){
		  userService.insertArrayUser(user);
	  }
	  
	  @GetMapping("/{username}")
		public UserProfile getUserById(@PathVariable (value = "username") String username) {
			return userService.getUser(username);
	 } 
	  
	  @GetMapping("/allUsers")
		public List<UserProfile> getUserById() {
			return userService.getAllUser();
	 } 
	  
	  @PutMapping(value="/{userName}")
	  public void updateUser(@PathVariable("userName") String userName,@RequestBody UserProfile user) {
		  userService.updateUser(userName,user);
	  }
	  
	  @DeleteMapping(value="/{userName}")
	  public void deleteUser(@PathVariable("userName") String userName)  throws Exception{
		  try{
			  userService.deleteUser(userName);
		  }catch(Exception e) {
			  e.printStackTrace();
			  
		  }
	  }
	  
	  @PostMapping(value={"/address"})
	  public void insertAddress(@RequestBody Address addr){
		  addressService.insertAddress(addr);
	  }
	  	  
	  @PostMapping(value={"/multipleAddress"})
	  public void insertMultipleAddress(@RequestBody List<Address> addr){
		  addressService.insertMultipleAddress(addr);
	  }
	  
	  @GetMapping(value={"/getAddress"})
	  public List<Address> getAddress(@RequestParam("username") String username){
		 return addressService.getAddress(username);
	  }
	  
}
