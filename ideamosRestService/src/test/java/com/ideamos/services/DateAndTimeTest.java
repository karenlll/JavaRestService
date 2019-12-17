package test.java.com.ideamos.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.com.ideamos.services.CurrencyFormatterService;
import main.java.com.ideamos.services.DateAndTimeService;

public class DateAndTimeTest {

	private DateAndTimeService dService;
	private String[] testValues = {"12 20 1999","35 40 2000","10 11 2001","04 06 2999"," 10 25 3000","45 02 3001"};
	private String testValueFormat;
	
	@Before
	public void setUp() throws Exception {
		dService = new DateAndTimeService();
		testValueFormat = "Hola";
	}
	
	@Test
	public void testCurrencyFormatterOne() {
		assertTrue( dService.dayOfWeek(testValues[0]).getEntity().toString().equals("NO VALID YEAR"));
		
	}
	
	@Test
	public void testCurrencyFormatterTwo() {
		assertTrue("Pass Test", dService.dayOfWeek(testValues[1]).getEntity().toString().equals("NO VALID DAY OR MONTH"));
	}
	
	@Test
	public void testCurrencyFormatterThree() {
		assertTrue("Pass Test", dService.dayOfWeek(testValues[2]).getEntity().toString().equals("THURSDAY"));
	}
	
	@Test
	public void testCurrencyFormatterFour() {

		assertTrue("Pass Test", dService.dayOfWeek(testValues[3]).getEntity().toString().equals("SATURDAY"));
	}
	
	@Test
	public void testCurrencyFormatterFive() {

		assertTrue("Pass Test", !dService.dayOfWeek(testValues[4]).getEntity().toString().equals("NO VALID YEAR"));
	}
	
	@Test
	public void testCurrencyFormatterSix() {

		assertTrue("Pass Test", dService.dayOfWeek(testValues[5]).getEntity().toString().equals("NO VALID DAY OR MONTH"));
	}
	
	@Test
	public void testCurrencyFormatterFormat() {

		assertTrue("Pass Test", dService.dayOfWeek(testValueFormat).getEntity().toString().equals("NO VALID DATE FORMAT"));
	}

}
