/*
 * This file has the functionalities related to User Table
 */
package com.user.UserInfo.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.user.UserInfo.Entity.UserProfile;

@Repository
public class userInfo  implements userDao{
	
	 @Autowired
	  private JdbcTemplate jdbcTemplate;
	 
	

	@Override
	public UserProfile getUser(String userName) {
		final String sql = "SELECT * FROM USER_PROFILE_INFO where username='"+userName+"';";
	
		  List<UserProfile> userdata= jdbcTemplate.query(sql,  new RowMapper<UserProfile>() {
			  public UserProfile mapRow(ResultSet resultSet, int i) throws SQLException {
				  UserProfile user = new UserProfile();
				  user.setId(resultSet.getInt("id"));
				  user.setFirstName(resultSet.getString("firstName"));
				  user.setLastName(resultSet.getString("lastName"));
				  user.setUserName(resultSet.getString("username"));
				  user.setPassword(resultSet.getString("password"));
				  user.setEmail(resultSet.getString("email"));
				  user.setPhone(resultSet.getString("phone"));
				  user.setGender(resultSet.getString("gender"));
				  user.setAnnualSalary(resultSet.getInt("annualSalary"));
				  user.setDateOfBirth(resultSet.getDate("dateOfBirth"));
				  user.setUserStatus(resultSet.getInt("userStatus"));
				  return user;
			  }
		  });
	 	 return userdata.get(0);
	}
	
	@Override
	public List<UserProfile> getAllUsers() {
		final String sql = "SELECT * FROM USER_PROFILE_INFO;";
	
		  List<UserProfile> usersdata= jdbcTemplate.query(sql,  new RowMapper<UserProfile>() {
			  public UserProfile mapRow(ResultSet resultSet, int i) throws SQLException {
				  UserProfile user = new UserProfile();
				  user.setId(resultSet.getInt("id"));
				  user.setFirstName(resultSet.getString("firstName"));
				  user.setLastName(resultSet.getString("lastName"));
				  user.setUserName(resultSet.getString("username"));
				  user.setPassword(resultSet.getString("password"));
				  user.setEmail(resultSet.getString("email"));
				  user.setPhone(resultSet.getString("phone"));
				  user.setGender(resultSet.getString("gender"));
				  user.setAnnualSalary(resultSet.getInt("annualSalary"));
				  user.setDateOfBirth(resultSet.getDate("dateOfBirth"));
				  user.setUserStatus(resultSet.getInt("userStatus"));
				  return user;
			  }
		  });
	 	 return usersdata;
	}
	
	@Override
	public List<UserProfile> getUserByDetails(String name, int userStatus){
		 String sql = "SELECT * FROM USER_PROFILE_INFO  ";
		
		if(!name.isEmpty() && userStatus!=0) {
			sql = sql + "where firstName='"+ name +"'and userStatus='" + userStatus +"';";
		}else if(name.isEmpty() && userStatus!=0) {
			sql = sql + "where " +" userStatus='" + userStatus +"';";
		}else if(name.isEmpty() && userStatus==0) {
			sql = sql + "where " +" firstName='" + name +"';";
		}
		  List<UserProfile> usersdata= jdbcTemplate.query(sql,  new RowMapper<UserProfile>() {
			  public UserProfile mapRow(ResultSet resultSet, int i) throws SQLException {
				  UserProfile user = new UserProfile();
				  user.setId(resultSet.getInt("id"));
				  user.setFirstName(resultSet.getString("firstName"));
				  user.setLastName(resultSet.getString("lastName"));
				  user.setUserName(resultSet.getString("username"));
				  user.setPassword(resultSet.getString("password"));
				  user.setEmail(resultSet.getString("email"));
				  user.setPhone(resultSet.getString("phone"));
				  user.setGender(resultSet.getString("gender"));
				  user.setAnnualSalary(resultSet.getInt("annualSalary"));
				  user.setDateOfBirth(resultSet.getDate("dateOfBirth"));
				  user.setUserStatus(resultSet.getInt("userStatus"));
				  return user;
			  }
		  });
	 	 return usersdata;
	}

	@Override
	public void insertUser(UserProfile user) {
		// TODO Auto-generated method stub
		
		final String sql = "INSERT INTO  USER_PROFILE_INFO(username,firstName,lastName,id,password,email,phone,userStatus,dateOfBirth) values(?,?,?,?,?,?,?,?,?)";
		
		final String userName=user.getUserName();
		final String firstName= user.getFirstName();
		final String lastName = user.getLastName();
		final int id = user.getId();
		final String password1 = user.getPassword();	
		final String email = user.getEmail();
		final String phone = user.getPhone();
		final int userStatus = user.getUserStatus();
		final Date dateofbirth = user.getDateOfBirth();
		  
		 jdbcTemplate.update(sql,new Object[] {userName,firstName,lastName,id,password1,email,phone,userStatus,dateofbirth} );
		
	}
	
	@Override
	public void insertArrayUser(List<UserProfile> user) {
		// TODO Auto-generated method stub		
		 for(UserProfile u:user){  
			 insertUser(u);
		 }  		
	}
	
	@Override
	public void updateUser(String paramUserName,UserProfile user) {
		// TODO Auto-generated method stub
		
		final String userName=user.getUserName();
		final String firstName= user.getFirstName();
		final String lastName = user.getLastName();
		final int id = user.getId();
		final String password1 = user.getPassword();	
		final String email = user.getEmail();
		final String phone = user.getPhone();
		final int userStatus = user.getUserStatus();
		  
		final String sql ="UPDATE USER_PROFILE_INFO SET id = "+ id +", username = '"+ userName+"', firstName = '"+ firstName +"', lastName = '"+ lastName +"'\r\n"+
						", password = '"+ password1 +"', email = '"+ email +"', phone = '"+ phone +"', userStatus = "+ userStatus  +  " WHERE username='"+ paramUserName+"';";
		
		 jdbcTemplate.update(sql);
		
	}
	
	@Override
	public void deleteUser(String paramUserName) {
		// TODO Auto-generated method stub
		  
		final String sql ="DELETE FROM USER_PROFILE_INFO "+ " WHERE username='"+ paramUserName+"';";
		
		 jdbcTemplate.update(sql);
		
	}
	

}
