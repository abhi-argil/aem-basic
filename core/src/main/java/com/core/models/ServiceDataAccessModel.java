package com.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.core.services.TrainingService;

@Model(adaptables = { Resource.class, SlingHttpServletRequest.class })
public class ServiceDataAccessModel {

	@OSGiService
	TrainingService trainingService;
	
	public String getName() {
		String te = trainingService.getAuthorName();
		return te;
	}
	public String[] getIntrest() {
		String[] te = trainingService.getAuthorIntrest();
		return te;
	}
	
	public String getNullField() {
		String te = trainingService.getAuthorNUllField();
		return te;
	}
}
