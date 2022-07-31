package com.user.UserInfo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "USER_ADDRESS")
public class Address {
	

	@Id
	@Column(name = "addrName")
	@NotEmpty
	private String addrName;
	
	@Column(name = "username")
	@NotEmpty
	private String username;
	
	@Column(name = "addrLn1")
	private String addrLn1;
	
	@Column(name = "stateCode")
	private String stateCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postalCode")
	private String postalCode;
	
	@Column(name = "country")
	private String country;
	
	
	
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddrName() {
		return addrName;
	}

	@JsonProperty("addrName")
	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	public String getAddrLn1() {
		return addrLn1;
	}

	@JsonProperty("addrLn1")
	public void setAddrLn1(String addrLn1) {
		this.addrLn1 = addrLn1;
	}

	public String getStateCode() {
		return stateCode;
	}

	@JsonProperty("stateCode")
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	@JsonProperty("postalCode")
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}
}
