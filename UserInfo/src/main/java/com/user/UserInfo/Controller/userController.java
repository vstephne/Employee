/*
 * This file has all API and is the starting point of execution for any API
 */

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

	// POST Call to insert a user into the database
	@PostMapping
	public void insertUser(@Valid @RequestBody UserProfile user) {
		userService.insertUser(user);
	}

	// POST Call to insert multiple users at one go
	@PostMapping(value = { "/createWithArray", "/createWithList" })
	public void insertUser(@Valid @RequestBody List<UserProfile> user) {
		userService.insertArrayUser(user);
	}

	//GET Call to get a single user detail provide username as path variable
	@GetMapping("/{username}")
	public UserProfile getUserById(@PathVariable("username") String username) {
		return userService.getUser(username);
	}

	//GET Call to get user based on his firstname and userStatus
	@GetMapping("/getDetail")
	public List<UserProfile> getUserByDetails(@RequestParam(value = "firstname") String name,
			@RequestParam(value = "userStatus") int userStatus) {
		return userService.getUserByDetails(name, userStatus);
	}

	//GET Call to get all User Details
	@GetMapping("/allUsers")
	public List<UserProfile> getUserById() {
		return userService.getAllUser();
	}

	//PUT Call to Update User Details
	@PutMapping(value = "/{userName}")
	public void updateUser(@PathVariable("userName") String userName, @RequestBody UserProfile user) {
		userService.updateUser(userName, user);
	}

	//DELETE Call to delete a User
	@DeleteMapping(value = "/{userName}")
	public void deleteUser(@PathVariable("userName") String userName) throws Exception {
		try {
			userService.deleteUser(userName);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	//POST Call to insert a address
	@PostMapping(value = { "/address" })
	public void insertAddress(@RequestBody Address addr) {
		addressService.insertAddress(addr);
	}

	//POST to insert multiple addresses 
	@PostMapping(value = { "/multipleAddress" })
	public void insertMultipleAddress(@RequestBody List<Address> addr) {
		addressService.insertMultipleAddress(addr);
	}

	//GET Call to get an address based username as request parameter
	@GetMapping(value = { "/getAddress" })
	public List<Address> getAddress(@RequestParam("username") String username) {
		return addressService.getAddress(username);
	}

}
