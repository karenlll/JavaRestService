package main.java.com.ideamos.services;

import java.time.LocalDate;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringEscapeUtils;

@Path("/dayOfWeek")
public class DateAndTimeService {

	
	
	public DateAndTimeService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@POST
    public Response dayOfWeek(@FormParam("date") String date) {
		
		try {
        String response="";
        
        String[] decomposeDate = date.split(" ");
        
        if(decomposeDate.length == 3 ) 
        {
        	if (tryParseInt(decomposeDate[0]) && tryParseInt(decomposeDate[1]) && tryParseInt(decomposeDate[2])) 
        	{
        		int month = Integer.parseInt(decomposeDate[0]);
        		int day = Integer.parseInt(decomposeDate[1]);
        		int year = Integer.parseInt(decomposeDate[2]);
        		if ( month >0 && month <13 && day>0 && day < 32) 
        		{
        			if (year > 2000 && year < 3000)
        				response= LocalDate.of(year, month, day).getDayOfWeek().toString();
        	        else
        	        	response= "NO VALID YEAR";
        		}else
        			response= "NO VALID DAY OR MONTH";
        	}else
        		response= "NO VALID DATE";
        }else
        	response= "NO VALID DATE FORMAT";
        
       response = StringEscapeUtils.escapeHtml(response);
        
        return Response.status(200).entity(response).build();
		
		}catch (NullPointerException e) 
		{
			return Response.status(200).entity("Required Param is null").build();
		}catch(Exception e) 
		{
			return Response.status(200).entity("Exception doesn't expected").build();
		}
    }
	
	private boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
	
}
