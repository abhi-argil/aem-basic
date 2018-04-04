package com.core.models;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;




@Model(adaptables= {Resource.class, SlingHttpServletRequest.class} )
public class DateFormatting {
   
	
	@Inject
	public GregorianCalendar tim;
	

	 public String getDate(){
		 SimpleDateFormat fmt = new SimpleDateFormat("dd/MMyyyy");
		    fmt.setCalendar(tim);
		    String dateFormatted = fmt.format(tim.getTime());
		    return dateFormatted;
	    }
	 
	 public String getTime(){
		 SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		    fmt.setCalendar(tim);
		    String dateFormatted = fmt.format(tim.getTime());
		    return dateFormatted;
	    }
	 
	
   
    
   
   
}
