package com.revature.screenforce.dtos;

import java.io.Serializable;
import java.util.Objects;


//5/27 JU - body from admin application

public class Bucket implements Serializable {

    private static final long serialVersionUID = 2435095816452768808L;

    private int bucketId;


    private String bucketDescription;


    private boolean isActive;

    public Bucket() {
        super();
    }

    public Bucket(Integer bucketId, String bucketDescription, Boolean isActive) {
        super();
        this.bucketId = bucketId;
        this.bucketDescription = bucketDescription;
        this.isActive = isActive;
    }

    /**
     * Getters & Setters
     */
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

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return getBucketId() == bucket.getBucketId() &&
                isActive == bucket.isActive &&
                Objects.equals(getBucketDescription(), bucket.getBucketDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBucketId(), getBucketDescription(), isActive);
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "bucketId=" + bucketId +
                ", bucketDescription='" + bucketDescription + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}