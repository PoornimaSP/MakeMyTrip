package mmtBase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class mmtBase {


		public static WebDriver driver;

	  FileInputStream fs;
	 public static Properties prop;
		

		
		public mmtBase()
		{ 
			try
			{
			 fs= new FileInputStream("C:\\Users\\welcome\\workspace\\MakeMyTrip.com\\src\\main\\java\\mmtconfig\\mmtconfig.properties");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		      prop = new Properties();
			try {
			prop.load(fs);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public void initilization()
		{
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			if (browser.equals("ff"))
			{
				System.setProperty("webdriver.gecko.driver","C://uday//geckodriver/geckodriver.exe");
			    driver = new FirefoxDriver();
			    
			}
			else
			{
				System.setProperty("webdriver.chrome.driver","C://uday//ChromeDriver/chromedriver.exe");
			     driver = new ChromeDriver();
			}
			
			driver.get("https://www.makemytrip.com/");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			
		}	
		
	}	

