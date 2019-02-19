package com.revature.screenforce.models;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ReportByEmailAndWeeksModel {
	Integer screenerId;
	String email;
	String name;
	
	public ReportByEmailAndWeeksModel(
			Integer screenerId, 
			String email,
			String name) {

		this.screenerId = screenerId;
		this.email = email;
		this.name = name;
	}
}

