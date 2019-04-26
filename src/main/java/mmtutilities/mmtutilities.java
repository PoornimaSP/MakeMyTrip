package mmtutilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import mmtBase.mmtBase;

public class mmtutilities extends mmtBase {
	
	public static void scrollPageDown(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	 public static void loadallflights() 
	 {
		 for(int i=1;i<=10;i++)
	 	 scrollPageDown(driver); 
		 
	 }

}
