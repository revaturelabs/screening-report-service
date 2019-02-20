package com.revature.screenforce.models;

public class ScreenerInfoModel {
	Integer screenerId;
	String email;
	String name;
	
	public ScreenerInfoModel(
			Integer screenerId, 
			String email,
			String name) {

		this.screenerId = screenerId;
		this.email = email;
		this.name = name;
	}
}

