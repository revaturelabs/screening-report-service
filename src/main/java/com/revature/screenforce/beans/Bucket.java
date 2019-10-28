package com.revature.screenforce.beans;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.List;
//import java.util.Objects;


/**
 *  The POJO for the bucket
 *  This version has the hibernate removed, 
 *  and the declaration is from feign client, used in the feign folder
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 */

//Hi Future Rex



public class Bucket {

    private int bucketId;
    private String bucketDescription;
    private boolean isActive;
    
	public int getBucketId() {
		return bucketId;
	}
	public void setBucketId(int bucketId) {
		this.bucketId = bucketId;
	}
	public String getBucketDescription() {
		return bucketDescription;
	}
	public void setBucketDescription(String bucketDescription) {
		this.bucketDescription = bucketDescription;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bucketId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bucket other = (Bucket) obj;
		if (bucketId != other.bucketId)
			return false;
		return true;
	}
	public Bucket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bucket(int bucketId, String bucketDescription, boolean isActive) {
		super();
		this.bucketId = bucketId;
		this.bucketDescription = bucketDescription;
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Bucket [bucketId=" + bucketId + ", bucketDescription=" + bucketDescription + ", isActive=" + isActive
				+ "]";
	}
 
  
}

