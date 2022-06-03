package test;
import isproject.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
//import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {
	
	final static int num = 1;
	private static CustomerService service;
	
	@BeforeClass
	public static void initTest() {
		service = new CustomerServiceImpl();
		System.out.println("BeforeClass: Uspesno inicijalizovan test");
	}
	
	@Before
	public void testPrecondition() {
		Customer c = service.getCustomer(100);
	    assertNull(c);
		System.out.println("Before: Preduslov");
	}
	
	@Test
	public void testAssertions() {		
		Customer obj = new Customer("Pera", "peric@elfak.rs", "321313", "Audi", "Test");
		service.addCustomer(obj);
		System.out.println("Test: dodavanje korisnika na 100. poziciju");
	}

	@After
	 public void testPostcondition() {
		 Customer c = service.getCustomer(num);
	     assertNotNull(c);
	     System.out.println("After: post-uslov");
	}
	
	@After
	public void testUpdate() {	
		service.updateCustomer(3, "Test", "testic@elfak.rs", "11111", "BMW", "0A1B");
		Customer obj = service.getCustomer(3);
		assertEquals(obj.getName(), "Test");
		assertEquals(obj.getEmail(), "testic@elfak.rs");
		assertEquals(obj.getPhone(), "11111");
		assertEquals(obj.getCarModel(), "BMW");
		assertEquals(obj.getCarPlate(), "0A1B");		
		 
		System.out.println("After: update");
	}
}
