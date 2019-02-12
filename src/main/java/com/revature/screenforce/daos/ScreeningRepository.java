package com.revature.screenforce.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.screenforce.beans.Screening;


@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
	 // @author Jakob LaSorella | 1805-WVU-MAY29 | Richard Orr
	
}

