package tfs_Web_Page;


import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;



public class HomePageWebElement {
	
	public WebDriver driver;
	
	@FindBy(id="userIdMail")
	@CacheLookup
	public WebElement typeUsername;
	@FindBy(id="password")
	@CacheLookup
	public WebElement typePWD;
	@FindBy(id="loginInSubmit")
	@CacheLookup
	public WebElement loginButton;
	
	public HomePageWebElement()
	{
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
	}
		
	public void load(String url)
	{
		driver.get(url);
	}	
	
	public void authentication(String username, String password)
	{
		typeUsername.sendKeys(username);
		typePWD.sendKeys(password);
	}
		
    public void jsClick(WebElement element)
	  {
		  try
		  {
			  if(element.isEnabled() | element.isDisplayed())
			  {
				  JavascriptExecutor js = (JavascriptExecutor) driver;
				  js.executeScript("arguments[0].click()", element);
			  }
			  else if(!element.isEnabled() && !element.isDisplayed())
			  {
				  System.out.println("The Element is not Displayed and Enabled");
			  }
			  else if(element.isEnabled())
			  {
				  System.out.println("The Element is not Displayed");
			  }
			  else
			  {
				  System.out.println("The Element is not isEnabled");
			  }
			  
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	  }
  
	public void login()
	{
		loginButton.click();
	}
	
}
