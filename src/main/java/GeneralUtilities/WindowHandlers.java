package GeneralUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlers
{
	WebDriver driver;
	
	public WindowHandlers()
	{
		driver = new ChromeDriver();
	}
	
	@Test
	public void windowHandlers()
	{
		//First driver opens first blank window
		System.out.println("Window Handle 1 : " + driver.getWindowHandle());
		
		//First site is loaded on the first blank window created by driver
		driver.get("https://www.amazon.com/");
		System.out.println("First site loaded : " + driver.getCurrentUrl());

		//Below code not working
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
		
        //Using JavascriptExecutor to create new window. A second blank window
		//By creating a new window the focus does not switch to it. Focus still on first window
        ((JavascriptExecutor) driver).executeScript("window.open();");
		
        //In order to switch focus between windows first convert SET to ArrayList
        //ArrayList works with indexes. So switch can be made using indexes
        Set<String> set = driver.getWindowHandles(); //Returns a Set
        List<String> lst = new ArrayList<String>(set); //Convert Set to a List

        //Switches focus to second window using index(1)
        driver.switchTo().window(lst.get(1));
		
		//Second site is loaded on the second blank window after switch
		driver.get("https://www.google.com/");
		System.out.println("Second site loaded : " + driver.getCurrentUrl());

		//Second window handle
		System.out.println("Window Handle 2 : " + driver.getWindowHandle());
		
		//Close the second window
          driver.close();
        
        //Switches focus from second window to first window
          driver.switchTo().window(lst.get(0));
        
        //Close the first window
          driver.close();
	}
}
