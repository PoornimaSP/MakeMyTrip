package mmtTest;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import mmtBase.mmtBase;
import mmtPages.mmtFlightPage;
import mmtPages.mmtHomePage;


public class mmtFlightPageTest extends mmtBase{
	
	mmtHomePage home;
	mmtFlightPage flights;
	
	@BeforeMethod
	public void setupTest() 
	{
		initilization();
		home= new mmtHomePage();
		home.selecttriptype();
		home.selectfromtolocation();
		home.selectdeparturedate();
		flights=home.searchFlights();		
		
	}
	
	@Test(priority=1)
	public void flightlistTest()
	{
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		flights.listofdepartureflights();	
		flights.listofreturnflights();
		
	}
	
	@Test(priority=2)
	public void nonstopflightlistTest()
	{  
		System.out.println("Non Stop flight List************");
		flights.nonstopflightlist();
		flights.listofdepartureflights();		
		flights.listofreturnflights();
	}
	
	@Test(priority=3)
	public void onestopflightlistTest()
	{
		System.out.println("One Stop flight List************");
		flights.onestopflightlist();
		flights.listofdepartureflights();		
		flights.listofreturnflights();
	}
	
	@Test(priority=4)
	public void ValidatepriceTest() 
	
	{
		String price[]= flights.selectdepandfretflight(3,5);
	    int Totalprice=Integer.valueOf(price[0])+ Integer.valueOf(price[1]);
	    
	    System.out.println("The total cost of departure and return flight travel is "+ Totalprice);
	    
	    Assert.assertEquals(price[0], price[2]);
	    Assert.assertEquals(price[1], price[3]);
		
	    int FareDetails = Integer.valueOf(price[4]);
	    
	   
	    Assert.assertEquals(FareDetails,Totalprice);
	   
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}


