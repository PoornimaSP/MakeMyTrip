package mmtPages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mmtBase.mmtBase;

import mmtutilities.mmtutilities;

public class mmtHomePage extends mmtBase{
	String flag ="false";
	
	@FindBy(xpath="//div[@class='widgetSection appendBottom40']//li[text()='Round Trip']")
	WebElement RoundtripRadioButton;
	
	@FindBy(xpath="//span[text()='From']")
	WebElement Fromlink;
	
	@FindBy(xpath=("//ul[@role='listbox' and @class='react-autosuggest__suggestions-list']//li//div//p[contains(text(),'Del')]"))
	WebElement FromLocation;
	
	@FindBy(xpath="//span[text()='To']")
	WebElement Tolink;
	
	@FindBy(xpath=("//ul[@role='listbox' and @class='react-autosuggest__suggestions-list']//li//div//p[contains(text(),'Bangalore')]"))
	WebElement ToLocation;
	
	@FindBy(xpath="//span[contains(text(),'DEPARTURE')]")
	WebElement departurelink;
	
	@FindBy(xpath="//a[contains(@class,'primaryBtn font24 latoBlack widgetSearchBtn')]")
	WebElement SearchFlights;
	
	public mmtHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selecttriptype()
	{
		RoundtripRadioButton.click();        	   

	}
	
	
	public void selectfromtolocation()
	{
	
		Fromlink.click();
		FromLocation.click();
		Tolink.click();
		ToLocation.click();
	}
	public mmtFlightPage searchFlights()
	{
		SearchFlights.click();
		return new mmtFlightPage();
	}
	
	public void selectdeparturedate() 
	{
    
		
	DateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM");
	Date date = new Date();
	String CurrentYYMMDD= dateFormat.format(date);
	System.out.println(CurrentYYMMDD);
	
	
	Calendar c1= Calendar.getInstance();					
	c1.setTime(date);
	c1.add(Calendar.DATE, 7);					
	Date rDate = c1.getTime();
	String sevenaddedDate = dateFormat.format(rDate);					
    System.out.println(sevenaddedDate);
   		   			
	
	
	String TodayDate = CurrentYYMMDD.split("/")[1].toString().trim().replaceFirst("0", "");
	String TodayMonth=CurrentYYMMDD.split("/")[2].toString().trim().replaceFirst("0", "");
	String retDate = sevenaddedDate.split("/")[1].toString().trim().replaceFirst("0", "");
	String retMonth = sevenaddedDate.split("/")[2].toString().trim().replaceFirst("0", "");
	
	
	String beforexpath="//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[";
	String afterxpath="]/div[";
	
	
		departurelink.click();
		
		for (int i=1;i<=5;i++)
		{
			for(int j=1;j<=7;j++)
			{
				String dvalue=driver.findElement(By.xpath(beforexpath+i+afterxpath+j+"]/div/p")).getText();
				//System.out.println(dvalue);
				
				if (dvalue.equals(TodayDate))
				{
					driver.findElement(By.xpath(beforexpath+i+afterxpath+j+"]/div/p")).click();
					 
					if (TodayMonth.equals(retMonth))
			        {
						for (int m=1;m<=5;m++)
						{
							for(int n=1;n<=7;n++)
							{
								String dvalue1=driver.findElement(By.xpath(beforexpath+m+afterxpath+n+"]/div/p")).getText();
								//System.out.println(dvalue1);
								
								if (dvalue1.equals(retDate))
								{
									driver.findElement(By.xpath(beforexpath+m+afterxpath+n+"]/div/p")).click();
								  				
									this.flag = "true";
		        					break;   
						         }
					
							
					           }
							if (this.flag.equals("true"))
	        					break;
					      }
						    
						if (this.flag.equals("true"))
        					break;
			        }	
					
			        	
			        	else
			        	{
			        		String retxpath="//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[";
			        		String retmidpath="]/div[";
			        		String retafterxpath="]/div/p";
			        		
			        		
			        		for (int k=1;k<=5;k++)
			        		{
			        			for(int l=1;l<=7;l++)
			        			{
			        				
			        					String rvalue=driver.findElement(By.xpath(retxpath+k+retmidpath+l+retafterxpath)).getText();
			        				        				
			        		
			        				//System.out.println(rvalue);
			        				
			        				if (rvalue.equals(retDate))
			        				{
			        					driver.findElement(By.xpath(retxpath+k+retmidpath+l+retafterxpath)).click();
			        					 this.flag = "true";
			        					break;
			        				}	
			        				
			        					        				  
			        				
			        	         }  
			        			 
			        			if (this.flag.equals("true"))
		        					break;
			                 }
			        		
			        		if (flag.equals("true"))
	        					break;
			           	}			


							
				        
		         }
	
				if (flag.equals("true"))
					break;
	           }
			
			
			if (flag.equals("true"))
				break;
	      }
	

	
         
	}		
		
}		



		
	