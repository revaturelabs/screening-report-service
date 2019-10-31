package com.revature.screenforce.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.revature.screenforce.beans.Category;

/**
 * The feignClient for category Takes Data from the screening-admin-service,
 * CategoryController
 * 
 * @author Zi Feng Chen | 1909-QC | Emily Higgins
 * @author George Ingleton | 1909-QC| Emily Higgins
 *
 */

@FeignClient(name = "category", url = "http://localhost:8181/category")
public interface FeignCategory {
	@RequestMapping(method = RequestMethod.GET)
	List<Category> getCategory();

	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	Category getCategoryByCategoryId(@PathVariable Integer categoryId);

}
