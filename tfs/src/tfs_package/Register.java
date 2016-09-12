package tfs_package;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.*;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Parameters;

public class Register {
	
	  WebDriver browser = new FirefoxDriver();
	  
	  public void jsClick(WebElement element)
	  {
		  try
		  {
		  if(element.isEnabled() | element.isDisplayed())
		  {
			  JavascriptExecutor js = (JavascriptExecutor) browser;
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
	  
	  @Parameters({"loginName","loginPassword"})
	  @Test
	  public void login(String loginName, String loginPassword)
	  {
		  try
		  {
		  browser.get("http://172.16.201.28:8080/security-server/login/show.htm");
		  WebElement loginNameField = browser.findElement(By.id("userIdMail"));
		  WebElement loginPasswordField = browser.findElement(By.id("password"));
		  WebElement login = browser.findElement(By.id("loginInSubmit"));
		  loginNameField.sendKeys(loginName);
		  loginPasswordField.sendKeys(loginPassword);
		  login.click();
		  //Assert.assertEquals(browser.findElement(By.xpath("html/body/div[1]/div/div[1]/span[2]")).getText(),"海钜信达统一权限管理系统");
		  
		  Thread.sleep(3000);
		  browser.get("http://www.beforeloan.tfs.com/TFS.PreLoan.Web/Report/CreditSumReportIndex");
		  //Assert.assertEquals(browser.findElement(By.xpath("html/body/div[1]/div/div[1]/span[2]")).getText(),"贷前预生产");
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	  }
	  
	  @Test(dependsOnMethods="login")
	  public void menu() 
	  {
		  WebElement menuButton = browser.findElement(By.xpath("//span[contains(text(),'借款登记')]"));
		  jsClick(menuButton);
		  //JavascriptExecutor js1 = (JavascriptExecutor) browser;
	      //js1.executeScript("arguments[0].click();", menuButton);
		  
		  //Assert.assertEquals(browser.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div/div/div[1]/label")).getText(), "借款申请/借款登记");
		  //Assert.assertFalse(browser.findElement(By.name("business_dept_name")).isEnabled());
	  }
	  
	  @Parameters({"customerName","customerID"})
	  @Test(dependsOnMethods="menu")
	  public void authentication(String customerName, String customerID) 
	  {
		  WebElement customerNameField = browser.findElement(By.id("CustomerName"));
		  WebElement customerIDField = browser.findElement(By.id("IdCard"));
		  WebElement searchButton = browser.findElement(By.name("Searchbtn"));
		  //WebElement registerButtonBeforeSearch = browser.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/div/div[4]"));                                                         
		  //System.out.println("register Button is enable" + registerButton.isEnabled());
		  //System.out.println("search Button is enable" + searchButton.isEnabled());
		  
		  customerNameField.sendKeys(customerName);
		  customerIDField.sendKeys(customerID);
		  searchButton.click();
		  try
		  {
			  Thread.sleep(5000);
			  WebElement registerButtonAfterSearch = browser.findElement(By.xpath("//a[text()='借款登记']"));
			  registerButtonAfterSearch.click();
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  /*
		  if(registerButton.isEnabled())
		  {
			  System.out.println("the button is disable now");
		  }
		  else
		  {
			  System.out.println("this user can be register");
		  }
		  */
		  
		  //Assert.assertEquals(browser.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div/div/div[1]/label")).getText(), "借款申请/借款登记");
		  //Assert.assertFalse(browser.findElement(By.name("business_dept_name")).isEnabled());
	  }
	  
	  @Parameters({"account","applyPurpose","product","period","urgentTpye","employee","urgentReason"})
	  @Test(dependsOnMethods="authentication")
	  public void registerDetail(String account, String applyPurpose, String product, String period, Boolean urgentTpye, String employee, String urgentReason)
	  {
		  WebElement accountField = browser.findElement(By.id("Application_apply_amount"));
		  Select applyPurposeSelector = new Select(browser.findElement(By.id("Application_apply_purpose")));
		  Select productSelector = new Select(browser.findElement(By.id("Application_product_type")));
		  Select periodSelector = new Select(browser.findElement(By.id("Application_apply_periods"))); 
		  WebElement employField = browser.findElement(By.id("employee_search")); 
		  WebElement registerButton = browser.findElement(By.id("btnSearch"));
		  
		  accountField.clear(); accountField.sendKeys(account);
		  applyPurposeSelector.selectByVisibleText(applyPurpose);
		  productSelector.selectByVisibleText(product);
		  periodSelector.selectByVisibleText(period);
		  
		
		  browser.findElement(By.id("employee_search")).click();
		  employField.sendKeys(employee);
		  
		  try
		  {
			  Thread.sleep(5000);
			  WebElement employField1 = browser.findElement(By.xpath("//a[contains(text(),'测试肖六:XS006')]"));
			  employField1.click();
			  Thread.sleep(5000);	   
			  
			  if(urgentTpye)
			  {
				  WebElement urgent = browser.findElement(By.id("urgent1"));
				  WebElement urgentReasonField = browser.findElement(By.id("Application_urgent_reason"));
				  urgent.click();
				  urgentReasonField.sendKeys(urgentReason);
			  }
			  else{}			 
			  
			  accountField.click();
			  Thread.sleep(5000);//为了把下拉不挡住加急原因
			  File filter = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(filter, new File("D:\\SVNLocal\\tfs\\screenshot\\register\\filter.png")); //打印登记详情的截图  
			  registerButton.click();
			  File result = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(result, new File("D:\\SVNLocal\\tfs\\screenshot\\register\\result.png"));//打印结果的截图
		  }
		  catch(IOException e)
		  {e.printStackTrace();}
		  catch(Exception e)
		  {e.printStackTrace();}
	  }
	  
	  @AfterMethod
	  public void afterMethod() throws Exception
	  {
		  Thread.sleep(3000);
	  }
	
	  @AfterTest
	  public void afterTest() {
		  System.out.println("exit");
		  browser.quit();
	  }

}
