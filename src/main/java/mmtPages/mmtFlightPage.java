package mmtPages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mmtBase.mmtBase;
import mmtutilities.mmtutilities;

public class mmtFlightPage extends mmtBase{
@FindBy(xpath="//div[@class='splitVw-sctn pull-left']//div[@class='fli-list splitVw-listing']//span[@class='font12 inlineB append_bottom7 insertSep'][1]")
List<WebElement> DepartureFlightNames;

@FindBy(xpath="//div[@class='splitVw-sctn pull-right']//div[@class='fli-list splitVw-listing']//span[@class='font12 inlineB append_bottom7 insertSep'][1]")
List<WebElement> ReturnFlightNames;

@FindBy(xpath="//label[@for='filter_stop0']//span[@class='check']")
WebElement NonStop;

@FindBy(xpath="//label[@for='filter_stop1']//span[@class='check']")
WebElement OneStop;

@FindBy(xpath="//div[@class='splitVw-sctn pull-left']//div[@class='fli-list splitVw-listing']//span[@class='splitVw-outer append_right9']")
List<WebElement> depflightradiobutton;

@FindBy(xpath="//div[@class='splitVw-sctn pull-right']//div[@class='fli-list splitVw-listing']//span[@class='splitVw-outer append_right9']")
List<WebElement> retflightradiobutton;

@FindBy(xpath="//div[@class='splitVw-sctn pull-left']//div[@class='fli-list splitVw-listing']//div[@class='pull-right marL5 text-right split-price-sctn']//p[@class='actual-price']//span")
List<WebElement> depflightprices;

@FindBy(xpath="//div[@class='splitVw-sctn pull-right']//div[@class='fli-list splitVw-listing']//div[@class='pull-right marL5 text-right split-price-sctn']//p[@class='actual-price']//span")
List<WebElement> retflightprices;

@FindBy(xpath="//div[@class='splitVw-footer-left ']//div[@class='pull-right marL5 text-right']//p[@class='actual-price']//span")
WebElement Finaldepflightprices;

@FindBy(xpath="//div[@class='splitVw-footer-right ']//div[@class='pull-right marL5 text-right']//p[@class='actual-price']//span")
WebElement Finalretflightprices;

@FindBy(xpath="//span[@class='splitVw-total-fare']")
WebElement FinalTotalflightprices;


public  mmtFlightPage()
{
	PageFactory.initElements(driver, this);
}

public void listofdepartureflights()
{ 
	mmtutilities.loadallflights();
	int depflightcount =DepartureFlightNames.size();	
	System.out.println("Please find below the list of " + depflightcount + "departure flights");
	for (int i=0;i<depflightcount;i++)
	{
				
		System.out.println(DepartureFlightNames.get(i).getText());
	}
}

public void listofreturnflights()

{ 
	
	
	mmtutilities.loadallflights();				
   int retflightcount =ReturnFlightNames.size();
	
	System.out.println("Please find below the list of " + retflightcount + "return flights");
	for (int i=0;i<retflightcount;i++)
	{
		
		
		System.out.println(ReturnFlightNames.get(i).getText());
	}
}

public void nonstopflightlist()
{
	NonStop.click();
	
	
}
public void onestopflightlist()
{
	OneStop.click();
	
	
}

public String[] selectdepandfretflight(int depflightorder,int returnflightorder) 


{   String price[]= new String[5];  
	mmtutilities.loadallflights();
	
	int depexactorder=depflightorder-1;
	JavascriptExecutor js2=((JavascriptExecutor)driver);
	js2.executeScript("arguments[0].click();",depflightradiobutton.get(depexactorder));
	
	price[0]=depflightprices.get(depexactorder*2).getText().replaceFirst("Rs", "").replaceAll(",", "").trim();
	System.out.println("Departure Flight #" +depflightorder+" is selected and its price is Rs"+ price[0]);
	
	
	
	int retexactorder=returnflightorder-1;
	JavascriptExecutor js1=((JavascriptExecutor)driver);
	js1.executeScript("arguments[0].click();",retflightradiobutton.get(retexactorder));
	
	price[1]=retflightprices.get(retexactorder*2).getText().replaceFirst("Rs", "").replaceAll(",", "").trim();
	System.out.println("Return Flight #" +returnflightorder+" is selected and its price is Rs"+ price[1]);
	
	price[2]=Finaldepflightprices.getText().replaceFirst("Rs", "").replaceAll(",", "").trim();
	
	price[3]=Finalretflightprices.getText().replaceFirst("Rs", "").replaceAll(",", "").trim();
	
	
	price[4] = FinalTotalflightprices.getText().replaceFirst("Rs", "").replaceAll(",", "").trim();
	
	
	
	
	return price;
}


}


