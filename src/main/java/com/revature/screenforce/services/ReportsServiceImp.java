package com.revature.screenforce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.Screener;
import com.revature.screenforce.daos.ScreenerRepository;

@Service
public class ReportsServiceImp{
	@Autowired
	private ScreenerRepository screenerRepository;
	
	public List<String> getAllEmails(String email){
		
		List<Screener> screenerList = screenerRepository.findAllByEmailContainingIgnoreCase(email);
		
		System.out.println(screenerList.size());
		
		List<String> emailList = new ArrayList<>();
		
		for(Screener screener : screenerList) {
				emailList.add(screener.getEmail());
		}
		
		return emailList;
	}

}
