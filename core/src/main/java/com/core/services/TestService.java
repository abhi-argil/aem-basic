package com.core.services;


import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.PropertyOption;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.ComponentContext;


@Service(value = TestService.class)
public class TestService{
	
/*	@Property(label="Name of the Author",value = "author") 
	private static final String AUTHOR_NAME = "author.value";
	private static String serviceVariableAuthorName;
	
	@Property(label="Age of the Author",intValue = 15)
	private static final String AUTHOR_AGE = "author.age";
	*/
	
//	@Property(label="Name",
//			   options = {
//			       @PropertyOption(name = "Abhinav", value = "Abhinav"),
//			       @PropertyOption(name = "Aditya", value = "Aditya"),
//			       @PropertyOption(name = "Somya", value = "Somya"),
//			       @PropertyOption(name = "Abhishek", value = "Abhishek")
//			   }
//			)
//	private static final String AUTHOR_NAME = "kkk.name";
//	private String authorName;
//	
//	@Property(value={"singing", "dancing","cooking"}, label = "Intrests", description = "Example for Multi field config") 
//	private static final String AUTHOR_INTREST = "author.intrest";
//	private String[] authorIntrest;
//	
//	
//	@Property(label="Extra field")
//	private static final String AUTHOR_NULLFIELD = "author.nullfield";
//	private String authorNUllField;
//
//	
//	public String getAuthorName() {
//		return authorName;
//		
//	}
//
//	public String getAuthorNUllField() {
//		return authorNUllField;
//	}
//
//	public String[] getAuthorIntrest() {
//		return authorIntrest;
//	}
//
//
//	@Activate
//	protected void activate(ComponentContext ctx) {
//		this.authorName = PropertiesUtil.toString(ctx.getProperties().get(AUTHOR_NAME),AUTHOR_NAME);
//		this.authorIntrest = PropertiesUtil.toStringArray(ctx.getProperties().get(AUTHOR_INTREST));
//		this.authorNUllField = PropertiesUtil.toString(ctx.getProperties().get(AUTHOR_NULLFIELD),AUTHOR_NULLFIELD);
//	}
//	
//	@Modified
//	protected void modified(ComponentContext ctx) {
//		this.authorName = PropertiesUtil.toString(ctx.getProperties().get(AUTHOR_NAME),AUTHOR_NAME);
//		this.authorIntrest = PropertiesUtil.toStringArray(ctx.getProperties().get(AUTHOR_INTREST));
//		this.authorNUllField = PropertiesUtil.toString(ctx.getProperties().get(AUTHOR_NULLFIELD),AUTHOR_NULLFIELD);
//	}
//	
	
	
	public String fun()
	{
		return "This is TestService";
	}
	
}
