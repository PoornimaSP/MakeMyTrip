package mmtutilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mmtBase.mmtBase;

public class mmtutilities extends mmtBase {
	
	public static void scrollPageDown(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	 public static void loadallflights() 
	 {
		 for(int i=1;i<=20;i++)
			 scrollPageDown(driver); 
		 
	 }
	 

}
