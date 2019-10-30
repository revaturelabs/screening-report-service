package com.revature.screenforce.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.revature.screenforce.beans.Track;


@FeignClient(name = "Track", url = "http://localhost:8181/track")
public interface FeignTrack {
	@RequestMapping(method = RequestMethod.GET)
	List<Track> getTrack();
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Track getTrackById(@PathVariable(value = "id") Integer id) ;
		

	
}


