package com.revature.screenforce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.daos.BucketDAO;

@Service
public class BucketService {
	@Autowired
	BucketDAO bucket;
	
	public Bucket getBucket(int id)
	{
		return bucket.findById(id).get();
	}
}
