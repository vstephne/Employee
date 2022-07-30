package com.user.UserInfo.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.user.UserInfo.Entity.Address;

@Repository
public class addressInfo implements addressDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertAddress(Address address) {
		// TODO Auto-generated method stub

		final String sql = "INSERT INTO  USER_ADDRESS(addrLn1, username, addrName,city, stateCode, postalCode, country) values(?,?,?,?,?,?,?)";

		final String addrLn1 = address.getAddrLn1();
		final String username = address.getUsername();
		final String addrName = address.getAddrName();
		final String city = address.getCity();
		final String stateCode = address.getStateCode();
		final String postalCode = address.getPostalCode();
		final String country = address.getCountry();

		jdbcTemplate.update(sql, new Object[] { addrLn1, username, addrName,city, stateCode, postalCode, country });

	}

	@Override
	public void insertMultipleAddress(List<Address> address) {
		// TODO Auto-generated method stub
		for (Address a:address) {
			insertAddress(a);
		}
	}
	
	@Override
	public List<Address> getAddress(String username) {
		final String sql = "SELECT * FROM USER_ADDRESS where username='"+ username+"';";
	
		  List<Address> usersAddress= jdbcTemplate.query(sql,  new RowMapper<Address>() {
			  public Address mapRow(ResultSet resultSet, int i) throws SQLException {
				  Address add = new Address();
				  add.setUsername(resultSet.getString("username"));
				  add.setAddrName(resultSet.getString("addrName"));
				  add.setAddrLn1(resultSet.getString("addrLn1"));
				  add.setCity(resultSet.getString("city"));
				  add.setStateCode(resultSet.getString("stateCode"));
				  add.setPostalCode(resultSet.getString("postalCode"));
				  add.setCountry(resultSet.getString("country"));
				  return add;
			  }
		  });
	 	 return usersAddress;
	}
}
