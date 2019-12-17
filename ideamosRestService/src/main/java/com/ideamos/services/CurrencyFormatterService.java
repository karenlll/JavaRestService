package main.java.com.ideamos.services;

import java.text.NumberFormat;
import java.util.Locale;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringEscapeUtils;

@Path("/currencyFormat")
public class CurrencyFormatterService {
	
	

	public CurrencyFormatterService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@POST
    public Response currencyFormatter(@FormParam("value") double value) {
		
		try {
        String response="";
        
        if(value>= 0 && value <= Math.pow(10, 9)) 
        {
        	NumberFormat formatter = NumberFormat.getInstance();
        	response += "US: " + formatter.getCurrencyInstance(Locale.US).format(value)+ System.getProperty("line.separator");  
        	response += "India: " + formatter.getCurrencyInstance(Locale.US).format(value).replace("$", "Rs.") +System.lineSeparator() ;  
        	response += "China: " + formatter.getCurrencyInstance(Locale.CHINA).format(value)+System.lineSeparator();  
        	response += "France: " + formatter.getCurrencyInstance(Locale.FRANCE).format(value)+System.lineSeparator();  
        	
        }else 
        {
        	response = "Valor no valido";
        }
        
       response = StringEscapeUtils.escapeHtml(response);
        
        return Response.status(200).entity(response).build();
        
		}catch (NullPointerException e) 
		{
			return Response.status(200).entity("Required Param is null").build();
		 } catch (NumberFormatException e) 
		{
			 return Response.status(200).entity("Number Format Exception").build();
		}
		catch(Exception e) 
		{
			return Response.status(200).entity("Exception doesn't expected").build();
		}
    }
	
}
