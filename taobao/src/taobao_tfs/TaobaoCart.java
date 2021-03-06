package taobao_tfs;



import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class TaobaoCart {
	
	
	  DesiredCapabilities dc = new DesiredCapabilities();
	  
	  
	  WebDriver browser = new FirefoxDriver(dc);
	  
	  @Parameters({"url"})
	  @Test
	  public void homePage(String url) 
	  {
		  try
		  {
			  browser.get(url);
		  }
		  catch(org.openqa.selenium.UnhandledAlertException e)
		  {
			  e.printStackTrace();		  
		  }
		 
	  }
	  
	  
	  @Parameters({"searchText"})
	  @Test(dependsOnMethods = "homePage")
	  public void search(String searchText) 
	  {
		  try
		  {
			  WebElement searchField = browser.findElement(By.id("q"));
			  searchField.clear();
			  searchField.sendKeys(searchText);
			  WebElement searchButton = browser.findElement(By.xpath("//button[contains(text(),'搜索')]"));
			  searchButton.click();	  
		  }
		  catch(org.openqa.selenium.UnhandledAlertException e)
		  {
			 browser.switchTo().alert().accept();
		  }
	  }
	  
	  @Parameters({"min","max","testCase"})
	  @Test(dependsOnMethods = "search")
	  public void filter(int min, int max, int testCase) throws Exception
	  {
		  WebElement sortBy = browser.findElement(By.linkText("销量"));
		  sortBy.click();
		  Thread.sleep(3000);
		  WebElement payMethod = browser.findElement(By.xpath("//span[contains(text(),'包邮')]"));
		  payMethod.click();
		  Thread.sleep(3000);
		  WebElement minPrice = browser.findElement(By.xpath("//input[contains(@aria-label,'价格最小值')]"));
		  WebElement maxPrice = browser.findElement(By.xpath("//input[contains(@aria-label,'价格最大值')]"));
		  WebElement confirmPrice = browser.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[1]/div[16]/div/div[1]/div/div[1]/div[1]/div/ul/li[4]/button"));
		  minPrice.sendKeys(String.valueOf(min));
		  maxPrice.sendKeys(String.valueOf(max));
		  Thread.sleep(3000);
		  JavascriptExecutor js1 = (JavascriptExecutor) browser;
	      js1.executeScript("arguments[0].click();", confirmPrice);
		  
	      
	      WebElement shipFrom = browser.findElement(By.xpath("//a[contains(text(),'广州')]"));
	      
	      if(testCase==1)
	      {
	    	  shipFrom = browser.findElement(By.xpath("//a[contains(text(),'广州')]")); 
	    	  System.out.println("city is guangzhou");
	      }
	      else if(testCase==2)
	      {
	    	  shipFrom = browser.findElement(By.xpath("//a[contains(text(),'深圳')]")); 
	    	  System.out.println("city is shenzhen");
	      }
	      else
	      {
	    	  
	    	  System.out.println(testCase==2);
	      }
	      
	      JavascriptExecutor js = (JavascriptExecutor) browser;
	      js.executeScript("arguments[0].click();", shipFrom);
	      
	      /*
	      System.out.println(sss);
	      WebElement shipFrom = browser.findElement(By.xpath("//a[contains(text(),"+sss+")]")); 
	      shipFrom.getText();
	      JavascriptExecutor js = (JavascriptExecutor) browser;
	      js.executeScript("arguments[0].click();", shipFrom);
	      */
	      
	      /*
		  Actions action = new Actions(browser);
		  WebElement nav = browser.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[1]/div[16]/div/div[1]/div/div[4]/div[1]/div/span[1]"));
		  action.moveToElement(nav).build().perform();
		  browser.findElement(By.linkText("深圳")).click();
		  */
	      
	      
	      
	
		 
		
	      
	      
	  }
	  
	  @Parameters({"s"})
	  @Test(dependsOnMethods = "filter")
	  public void chooseItem(String s) throws Exception
	  {
		  WebElement item = browser.findElement(By.linkText(s));
		  item.click();
	  }
	  
	  @Test(dependsOnMethods = "chooseItem")
	  public void newWindows() throws Exception
	  {
		  String [] handles = new String[browser.getWindowHandles().size()];
		  browser.getWindowHandles().toArray(handles);
		  browser.switchTo().window(handles[1]);
		  WebElement addToCart = browser.findElement(By.id("J_LinkBasket"));
		  addToCart.click();
	  }
	  
	  @Parameters({"username","password"})
	  @Test(dependsOnMethods = "newWindows")
	  public void login(String username, String password) throws Exception
	  {
		  Thread.sleep(10000);
		  browser.switchTo().frame(browser.findElement(By.className("j_minilogin_iframe")));
		  WebElement useInDesktop = browser.findElement(By.id("J_Quick2Static"));
		  useInDesktop.click();
		  WebElement loginUsername = browser.findElement(By.id("TPL_username_1"));
		  WebElement loginPassword = browser.findElement(By.id("TPL_password_1"));
		  WebElement loginButton = browser.findElement(By.id("J_SubmitStatic"));
		  loginUsername.sendKeys(username);
		  loginPassword.sendKeys(password);
		  loginButton.click();
		  Thread.sleep(10000);
	  }
	  
	  @AfterMethod 
	  public void beforeMethod() throws Exception
	  {
		  Thread.sleep(5000);
	  }
	  
	  @AfterClass
	  public void afterClass() throws Exception
	  {
		  browser.quit();
	  }

}
