package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import NIMCOKARLD_LINUX_JUNIT.csbsju.ntc.NewTelephoneCompany;

public class NewTelephoneCompanyTest_WBT {
	
	  private NewTelephoneCompany ntc ;
	  
	@Before
	  public void setUp() throws Exception {
	   ntc = new NewTelephoneCompany();
	  }
	

	@Test(expected =UnsupportedOperationException.class)
	public void testSetStartTimeNegative() {
		ntc.setStartTime(-5);
		ntc.computeCharge();
	}
	
	@Test(expected =UnsupportedOperationException.class)
	public void testSetStartTimeNegOne() {
		ntc.setStartTime(-1);
		ntc.computeCharge();
	}

	@Test(expected =UnsupportedOperationException.class)
	public void testSetStartTimeGreater() {
		ntc.setStartTime(2544);
		ntc.computeCharge();
	}

	@Test(expected =UnsupportedOperationException.class)
	public void testSetStartTime2400() {
		ntc.setStartTime(2400);
		ntc.computeCharge();
	}


	@Test(expected =UnsupportedOperationException.class)
	public void testSetStartTimeGreat2400() {
		ntc.setStartTime(2401);
		ntc.computeCharge();
	}
	
	@Test(expected =UnsupportedOperationException.class)
	public void testSetStartTimeGreatMinutes() {
		ntc.setStartTime(1578);
		ntc.computeCharge();
	}
	@Test(expected =UnsupportedOperationException.class)
	public void testSetStartTimeGreatMinutes2() {
		ntc.setStartTime(1160);
		ntc.computeCharge();
	}
	@Test(expected =UnsupportedOperationException.class)
	public void testSetStartTimeGreatMinutes3() {
		ntc.setStartTime(1161);
		ntc.computeCharge();
	}
	@Test(expected =UnsupportedOperationException.class)
	public void testSetStartTimeGreatMinutes4() {
		ntc.setStartTime(799);
		ntc.computeCharge();
	}
	@Test(expected =UnsupportedOperationException.class)
	public void testSetDuration0() {
		ntc.setDuration(0);
		ntc.computeCharge();
	}
	@Test(expected =UnsupportedOperationException.class)
	public void testSetDurationNega() {
		ntc.setDuration(-1);
		ntc.computeCharge();
	}
	
	@Test
	  public void testComputeCharge_StartTimeAndDurationDiscount() {
	    ntc.setStartTime(500);
	    ntc.setDuration(100);
	    double expResult = 1768.0;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	    ntc.setStartTime(759);
	    ntc.setDuration(61);
	    expResult = 1078.48;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	    ntc.setStartTime(1959);
	    ntc.setDuration(61);
	    expResult = 1078.48;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	    ntc.setStartTime(2359);
	    ntc.setDuration(65);
	    expResult = 1149.2;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	
	    
	}
	@Test
	public void testComputeCharge_DiscountedStartTimeOnly() {
		
		ntc.setStartTime(0);
	    ntc.setDuration(60);
	    double expResult = 1248.0;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	    ntc.setStartTime(400);
	    ntc.setDuration(59);
	    expResult = 1227.2;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	    ntc.setStartTime(1800);
	    ntc.setDuration(10);
	    expResult = 208.0;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	    ntc.setStartTime(1801);
	    ntc.setDuration(10);
	    expResult = 208.0;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	    ntc.setStartTime(2359);
	    ntc.setDuration(10);
	    expResult = 208.0;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	
	}
	@Test
	public void testComputeCharge_DiscountedDurationOnly() {
		
		ntc.setStartTime(800);
	    ntc.setDuration(65);
	    double expResult = 2298.4;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	    ntc.setStartTime(900);
	    ntc.setDuration(61);
	    expResult = 2156.96;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	    
	}
	
	@Test
	public void testComputeCharge_NoDiscount() {
		
		ntc.setStartTime(1000);
	    ntc.setDuration(40);
	    double expResult = 1664.0;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	    ntc.setStartTime(800);
	    ntc.setDuration(1);
	    expResult = 41.6;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	    ntc.setStartTime(801);
	    ntc.setDuration(59);
	     expResult = 2454.4;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	    ntc.setStartTime(1759);
	    ntc.setDuration(60);
	    expResult = 2496.0;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	    
	}

}
