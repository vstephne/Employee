package com.user.UserInfo.Dao;

import java.util.List;

import com.user.UserInfo.Entity.Address;

public interface addressDao {
   void insertAddress(Address address);
   void insertMultipleAddress(List<Address> address);
   List<Address> getAddress(String username);
}
