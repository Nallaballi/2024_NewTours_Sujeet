package PageObjects;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ApplicationUtilities.ApplicationUtilities;
import ReadProperties.ReadProperties;



public class Flights
{
	WebDriver driver;
	ReadProperties myProp;
	ApplicationUtilities myUtils;
	
	public Flights()
	{
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\nalla\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		myProp = new ReadProperties ("InputData.properties");
		myUtils = new ApplicationUtilities(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		//driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
	}
	
	@Before
	public void openChromeBrowser()
	{
		driver.get(myProp.propertiesFile("URL"));
		driver.manage().window().maximize();
	
		//System.out.println(driver.getTitle());
		//System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getWindowHandle());
	}
	
	@Test
	public void testChromeBrowser()
	{
		myUtils.selectSingleWebElement("name","userName").sendKeys(myProp.propertiesFile("UserName"));
		myUtils.selectSingleWebElement("name","password").sendKeys(myProp.propertiesFile("Password"));
		myUtils.selectSingleWebElement("name","submit").click();
		myUtils.selectWebElementWithDynamicXpath();
		myUtils.selectSingleWebElement("linkText","Flights").click();
		myUtils.selectSingleWebElementFromCollection("name","tripType","defaultValue","oneway").click();
		myUtils.selectFromDropdown("passCount","2");
		myUtils.selectFromDropdown("fromPort","London");
		myUtils.selectFromDropdown("fromMonth","June");
		myUtils.selectFromDropdown("fromDay","10");
		myUtils.selectFromDropdown("toPort","Paris");
		myUtils.selectFromDropdown("toMonth","July");
		myUtils.selectFromDropdown("toDay","10");
		myUtils.selectSingleWebElementFromCollection("name","servClass","value","Business").click();
		myUtils.selectFromDropdown("airline","Unified Airlines");	
		myUtils.selectSingleWebElement("name","findFlights").click();
		myUtils.selectSingleWebElement("partialLinkText","SIGN").click();
	}
	
	@After
	public void closeChromeBrowser()
	{
		driver.close();//Closes the current window is closes
		driver.quit();//Closes all associate windows opened by that driver
	}
	
	
}
