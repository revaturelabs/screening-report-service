package com.revature.screenforce.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

//5/27 JU body from screening application
public enum ScheduledStatus {
	@JsonProperty("PENDING")
	PENDING,
	@JsonProperty("SCREENED")
	SCREENED
}
