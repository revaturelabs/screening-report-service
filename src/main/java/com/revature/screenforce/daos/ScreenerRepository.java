package com.revature.screenforce.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.screenforce.beans.Screener;

@Repository
public interface ScreenerRepository extends JpaRepository<Screener, Integer>{
    public Screener getByEmail(String email);
	public List<Screener> findAllByEmailContainingIgnoreCase(String email);
	public List<Screener> findAll();
}