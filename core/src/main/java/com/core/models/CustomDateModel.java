package com.core.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { Resource.class, SlingHttpServletRequest.class })
public class CustomDateModel {

	@Inject
	@Via("resource")
	private String headerDate;
	
	
	@ValueMapValue
	@Named("jcr:created")
	private  java.util.Calendar date;

	public String getDate1() {
		return date.getTime().toString();
	}

	public List<String> getDate() throws ParseException {
		
	//	return headerDate;
				
		

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		Date date = df.parse(headerDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		String result;

		SimpleDateFormat formatDay = new SimpleDateFormat("EEEE");
		formatDay.setCalendar(cal);
		
		String dayFormatted;
		dayFormatted = formatDay.format(cal.getTime());

		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		formatDate.setCalendar(cal);
		String dateFormatted;
		dateFormatted = formatDate.format(cal.getTime());

		List<String> al = new ArrayList<String>();
		result = "date: " + dateFormatted + ", Day: " + dayFormatted;
		al.add(result);

		for (int i = 0; i < 5; i++) {
			cal.add(Calendar.DATE, 7);
			formatDate.setCalendar(cal);
			dateFormatted = formatDate.format(cal.getTime());
			result = "next " + dayFormatted + " : " + dateFormatted;
			al.add(result);
		}
		return al;
	}

}
