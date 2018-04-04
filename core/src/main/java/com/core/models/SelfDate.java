package com.core.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

@Model(adaptables = { Resource.class })
public class SelfDate {
   @Self
   private Resource resource;
   

   public String getName() {
       return "nishant";
   }

   public String value;

   public String getDate() throws ValueFormatException, PathNotFoundException, RepositoryException {
       Node node = resource.adaptTo(Node.class);
       Calendar p = node.getProperty("jcr:created").getValue().getDate();
      // return p.toString();
       SimpleDateFormat fmt = new SimpleDateFormat("dd/MMyyyy HH:mm:ss");
	    fmt.setCalendar(p);
	    String dateFormatted = fmt.format(p.getTime());
	    return dateFormatted;
   }

}