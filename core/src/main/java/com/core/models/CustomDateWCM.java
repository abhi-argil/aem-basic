package com.core.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.jcr.Node;

import org.apache.sling.api.resource.Resource;

import com.adobe.cq.sightly.WCMUse;

public class CustomDateWCM extends WCMUse{

	private  String dateFormatted;
	
	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		Resource resource = getResource();
		 Node node = resource.adaptTo(Node.class);
	       Calendar p = node.getProperty("headerDate").getValue().getDate();
	      // return p.toString();
	       SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		    fmt.setCalendar(p);
		    dateFormatted = fmt.format(p.getTime());	
	}
	
	public String getDate() {
		return dateFormatted;
	}

}
