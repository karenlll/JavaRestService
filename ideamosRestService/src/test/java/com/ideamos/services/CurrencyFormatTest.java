package test.java.com.ideamos.services;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.java.com.ideamos.services.CurrencyFormatterService;

public class CurrencyFormatTest {
	
	private CurrencyFormatterService cService;
	private double[] testValues = {-1, 0, 1, 999999999, 1000000000, 1000000001};
	private String testValueFormat;

	@Before
	public void setUp() throws Exception {
		cService = new CurrencyFormatterService();
		testValueFormat = "Hola";
	}

	@Test
	public void testCurrencyFormatterOne() {
		assertTrue( cService.currencyFormatter(testValues[0]).getEntity().toString().equals("Valor no valido"));
		
	}
	
	@Test
	public void testCurrencyFormatterTwo() {
		assertTrue("Pass Test", !cService.currencyFormatter(testValues[1]).equals("Valor no valido"));
	}
	
	@Test
	public void testCurrencyFormatterThree() {
		assertTrue("Pass Test", !cService.currencyFormatter(testValues[2]).equals("Valor no valido"));
	}
	
	@Test
	public void testCurrencyFormatterFour() {

		assertTrue("Pass Test", !cService.currencyFormatter(testValues[3]).equals("Valor no valido"));
	}
	
	@Test
	public void testCurrencyFormatterFive() {

		assertTrue("Pass Test", !cService.currencyFormatter(testValues[4]).equals("Valor no valido"));
	}
	
	@Test
	public void testCurrencyFormatterSix() {

		assertTrue("Pass Test", cService.currencyFormatter(testValues[5]).getEntity().toString().equals("Valor no valido"));
	}
	
/*	@Test
	public void testCurrencyFormatterFormat() {

		assertTrue("Pass Test", cService.currencyFormatter(testValueFormat).getEntity().toString().equals("Valor no valido"));
	}*/
	

}
