package com.user.UserInfo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.UserInfo.Dao.*;
import com.user.UserInfo.Entity.Address;

@Service
public class addressService {
	@Autowired
	private addressDao addressDao;

	public void insertAddress(Address address) {
		this.addressDao.insertAddress(address);		
	}
	
	public void insertMultipleAddress(List<Address> address) {
		this.addressDao.insertMultipleAddress(address);		
	}
	
	public List<Address> getAddress(String username){
		return this.addressDao.getAddress(username);
	}
}
