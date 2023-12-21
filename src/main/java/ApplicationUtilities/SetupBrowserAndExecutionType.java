
package ApplicationUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ReadProperties.ReadProperties;

public class SetupBrowserAndExecutionType 
{
	//Main reason for the TestSetup is to get the driver
	//And pass it on to the other Classes. They should always be only one driver
	//Each Class may have its own properties file. But only one driver object
	
	ReadProperties read;
	WebDriver driver;
	
	public SetupBrowserAndExecutionType()
	{
		read = new ReadProperties("Data/InputData.properties");
	}
	
	public WebDriver chooseExecutionType()
	{
		if(read.propertiesFile("ExecutionType").equalsIgnoreCase("local"))
		{
			driver = chooseDriver();
		}
		else if(read.propertiesFile("ExecutionType").equalsIgnoreCase("remote"))
		{
			driver = chooseDriver();
		}
		else
		{
			driver = chooseDriver();
		}
		return driver;
	}
	
	public WebDriver chooseDriver()
	{
		if(read.propertiesFile("Browser").equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(read.propertiesFile("Browser").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		else
		{
			driver = new ChromeDriver();
		}
		
		return driver;
	}
}