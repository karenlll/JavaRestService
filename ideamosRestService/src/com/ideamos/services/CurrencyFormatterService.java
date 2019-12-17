package com.ideamos.services;

import java.text.NumberFormat;
import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringEscapeUtils;

@Path("/currencyFormat")
public class CurrencyFormatterService {

	@GET
    public Response currencyFormatter(@QueryParam("value") double value) {
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
        	response = "Valor no válido";
        }
        
       response = StringEscapeUtils.escapeHtml(response);
        
        return Response.status(200).entity(response).build();
    }
	
}
