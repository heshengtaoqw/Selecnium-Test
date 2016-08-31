package taobao_tfs;

import java.awt.List;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class TaobaoCart {
	
	  WebDriver browser = new FirefoxDriver();
	  
	  @Parameters({"url"})
	  @Test
	  public void homePage(String url) throws Exception
	  {
		  browser.get(url);
	  }
	  
	  @Parameters({"searchText"})
	  @Test(dependsOnMethods = "homePage")
	  public void search(String searchText) throws Exception
	  {
		  WebElement searchField = browser.findElement(By.id("q"));
		  searchField.sendKeys(searchText);
		  WebElement searchButton = browser.findElement(By.xpath("//button[contains(text(),'搜索')]"));
		  searchButton.click();
	  }
	  
	  @Parameters({"min","max"})
	  @Test(dependsOnMethods = "search")
	  public void filter(int min, int max) throws Exception
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
		  JavascriptExecutor js = (JavascriptExecutor) browser;
	      js.executeScript("arguments[0].click();", shipFrom);
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
