package ApplicationUtilities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ApplicationUtilities 
{
	WebDriver driver;
	WebElement element;
	List<WebElement> collection;
	
	public ApplicationUtilities(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//---selectingSingleWebElement----Has Only One Part----------
	
		public WebElement selectSingleWebElement(String locatorType,String locatorValue)
		{
			if(locatorType.equals("id"))
				element  = driver.findElement(By.id(locatorValue));
			
			else if (locatorType.equals("name"))
				element  = driver.findElement(By.name(locatorValue));
			
			else if (locatorType.equals("className"))
				element  = driver.findElement(By.className(locatorValue));
			
			else if (locatorType.equals("cssSelector"))
				element = driver.findElement(By.cssSelector(locatorValue));
			
			else if (locatorType.equals("linkText"))
				element  = driver.findElement(By.linkText(locatorValue));
			
			else if (locatorType.equals("partialLinkText"))
				element  = driver.findElement(By.partialLinkText(locatorValue));
			
			else if (locatorType.equals("tagName"))
				element  = driver.findElement(By.tagName(locatorValue));
			
			else if (locatorType.equals("xpath"))
				element  = driver.findElement(By.xpath(locatorValue));
			return element;	
		}
		
		//---selectingSingleWebElementFromCollection----Has Two Parts----------
		
		public List<WebElement> returnCollection(String locatorType,String locatorValue)
		{
			if(locatorType.equals("id"))
			collection = driver.findElements(By.id(locatorValue));
			
			else if (locatorType.equals("name"))
			collection = driver.findElements(By.name(locatorValue));
			
			else if (locatorType.equals("className"))
			collection = driver.findElements(By.className(locatorValue));
			
			else if (locatorType.equals("cssSelector"))
			collection = driver.findElements(By.cssSelector(locatorValue));
			
			else if (locatorType.equals("linkText"))
			collection  = driver.findElements(By.linkText(locatorValue));
			
			else if (locatorType.equals("partialLinkText"))
			collection = driver.findElements(By.partialLinkText(locatorValue));
			
			else if (locatorType.equals("tagName"))
			collection = driver.findElements(By.tagName(locatorValue));
			
			else if (locatorType.equals("xpath"))
			collection = driver.findElements(By.xpath(locatorValue));
			
			return collection;
		}
		
		public WebElement selectSingleWebElementFromCollection(String locatorType,String locatorValue,String attributeType,String attributeValue)
		{
			collection = returnCollection(locatorType,locatorValue);
			for(int i=0;i < collection.size();i++)
			{
				String text = collection.get(i).getAttribute(attributeType);
				if(text.equals(attributeValue))
				{
					element = collection.get(i);
					break;
				}
			}
			return element;
		}
	
		//-------Xpath------------------------------------------------------------
		public void selectWebElementWithStaticXpath()
		{
			driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
		}
		
		public void selectWebElementWithDynamicXpath()
		{
			driver.findElement(By.xpath("//a[contains(@href,'register.php')]")).click();
		}

		//------------------------------------------------------------------------
		
		public void selectFromDropdown(String dropDown,String dValue)
		{
			new Select(driver.findElement(By.name(dropDown))).selectByVisibleText(dValue);
		}
		
		public void selectFromDropdown(String dropDown,int indexValue)
		{
			new Select(driver.findElement(By.name(dropDown))).selectByIndex(indexValue);
		}
}
