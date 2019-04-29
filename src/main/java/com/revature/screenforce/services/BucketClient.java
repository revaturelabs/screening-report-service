package com.revature.screenforce.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.beans.Question;

import feign.RequestLine;

public interface BucketClient {
	@RequestLine("GET /{bucketId}")
	public Bucket getBucketById(@PathVariable Integer bucketId);
}
