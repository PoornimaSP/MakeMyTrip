package mmtTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mmtBase.mmtBase;
import mmtPages.mmtFlightPage;
import mmtPages.mmtHomePage;



public class mmtHomePageTest extends mmtBase{
	
	mmtHomePage home;
	mmtFlightPage flights;
	
	@BeforeMethod
	public void setupTest() 
	{
		initilization();
		home= new mmtHomePage();
		
		
		
	}
    
		
	@Test(priority =1)
	public void selectfromtolocationtest()
	{
		home.selecttriptype();
		home.selectfromtolocation();
		home.selectdeparturedate();
		flights=home.searchFlights();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.makemytrip.com/flight/search?itinerary=DEL-BLR-25/04/2019_BLR-DEL-01/05/2019&tripType=R&paxType=A-1_C-0_I-0&intl=false&=&cabinClass=E");
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
}

