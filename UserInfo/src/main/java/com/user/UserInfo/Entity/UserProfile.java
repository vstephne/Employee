package com.user.UserInfo.Entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "USER_PROFILE_INFO")
public class UserProfile {

	
	@Id
	@Column(name = "id")
	private int id;

	
	
	@Size(min=10,max=15,message="password should be minimum 10 charecters and maximum 15 charecters")
	@Column(name = "password")
	private String password;

	
	@Column(name = "username")
	private String userName;

	
	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "annualSalary")
	private int annualSalary;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateOfBirth")
	private Date dateOfBirth;

	// email of the user
	@Email
	@Column(name = "email")
	private String email;

	@Column(name = "gender")
	private String gender;

	@Size(min = 10, max = 10, message = "Phone number must be 10 digits")
	@Column(name = "phone")
	private String phone;

	@Column(name = "userStatus")
	private int userStatus;

	public String getUserName() {
		return userName;
	}

	@JsonProperty("username")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	@JsonProperty("annualSalary")
	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	@JsonProperty("dateOfBirth")
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	@JsonProperty("gender")
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	@JsonProperty("phone")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUserStatus() {
		return userStatus;
	}

	@JsonProperty("userStatus")
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public String getPassword() {
		return password;
	}

	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

}
