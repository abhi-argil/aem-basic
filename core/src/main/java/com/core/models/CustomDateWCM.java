package com.core.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jcr.Node;

import org.apache.sling.api.resource.Resource;

import com.adobe.cq.sightly.WCMUsePojo;

public class CustomDateWCM extends WCMUsePojo {

	private List<String> al = new ArrayList<String>();

	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		Resource resource = getResource();
		Node node = resource.adaptTo(Node.class);

		Calendar p = node.getProperty("headerDate").getValue().getDate();

		String dateFormatted;
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		formatDate.setCalendar(p);
		dateFormatted = formatDate.format(p.getTime());

		String dayFormatted;
		SimpleDateFormat formatDay = new SimpleDateFormat("EEEE");
		formatDay.setCalendar(p);
		dayFormatted = formatDay.format(p.getTime());

		String result;
		result = "date: " + dateFormatted + ", Day: " + dayFormatted;
		al.add(result);
		for (int i = 0; i < 5; i++) {
			p.add(Calendar.DATE, 7);

			formatDate.setCalendar(p);
			dateFormatted = formatDate.format(p.getTime());

			result = "next " + dayFormatted + " : " + dateFormatted;
			al.add(result);
		}
	}

	public List<String> getDate() {
		return al;
	}

}
