package com.bankapp.web.beanconfig;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRequestBean {
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
