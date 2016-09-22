package tfs_package;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import tfs_package.Register;

public class ApplicationAssign {
	
	  Register r = new Register();

	  @Parameters({"loginName","loginPassword"})
	  @Test
	  public void login(String loginName, String loginPassword)
	  {
		  r.login(loginName, loginPassword);
	  }
	  
	  @Parameters({"s"})
	  @Test(dependsOnMethods="login")
	  public void menu(String s) 
	  {
		  
		  WebElement menuButton = r.browser.findElement(By.xpath("//span[contains(text(),'"+s+"')]"));
		  r.jsClick(menuButton);
		  //JavascriptExecutor js1 = (JavascriptExecutor) browser;
	      //js1.executeScript("arguments[0].click();", menuButton);
		  
		  //Assert.assertEquals(browser.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div/div/div[1]/label")).getText(), "借款申请/借款登记");
		  //Assert.assertFalse(browser.findElement(By.name("business_dept_name")).isEnabled());
	  }
	  
	  @Parameters({"salesmanName","groupLeaderName","customerName","customerID"})
	  @Test(dependsOnMethods = "menu")
	  public void filter(String salesmanName, String groupLeaderName, String customerName, String customerID)
	  {
		  WebElement custNameField = r.browser.findElement(By.id("cust_name"));
		  WebElement idCardField = r.browser.findElement(By.id("id_card"));
		  WebElement salesmanNameField = r.browser.findElement(By.id("salesman_name"));
		  WebElement groupLeaderNameField = r.browser.findElement(By.id("group_leader_name"));
		  
		  custNameField.sendKeys(customerName);
		  idCardField.sendKeys(customerID);
		  
		  try
		  {
			  salesmanNameField.sendKeys(salesmanName);
			  Thread.sleep(7000);
			  r.browser.findElement(By.xpath("//a[contains(text(),'"+salesmanName+"')]")).click();;
			  
			  groupLeaderNameField.sendKeys(groupLeaderName);
			  Thread.sleep(7000);
			  r.browser.findElement(By.xpath("//a[contains(text(),'"+groupLeaderName+"')]")).click();;
			  
			  custNameField.click();
			  File filter = ((TakesScreenshot)r.browser).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(filter, new File("D:\\SVNLocal\\tfs\\screenshot\\ApplicationAssign\\filter.png")); //打印登记详情的截图  
			  
			  WebElement searchButton = r.browser.findElement(By.name("Searchbtn"));
			  searchButton.click();
			  Thread.sleep(5000);
			  File result = ((TakesScreenshot)r.browser).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(result, new File("D:\\SVNLocal\\tfs\\screenshot\\ApplicationAssign\\result.png"));//打印结果的截图
			  
		  }
		  catch(IOException e)
		  {e.printStackTrace();}
		  catch(Exception e)
		  {e.printStackTrace();}
		  
	  }
	  
	  @Parameters({"serverName"})
	  @Test(dependsOnMethods = "filter")
	  public void assign(String serverName)
	  {
		  try
		  {
			  WebElement assignButton = r.browser.findElement(By.name("lookLog"));
			  r.jsClick(assignButton);
			  Thread.sleep(3000); //这里延迟，是因为下面的元素要等待页面加载
			  WebElement assignTo = r.browser.findElement(By.id("employee_search"));
			  System.out.println(assignTo.isDisplayed());
			  assignTo.sendKeys(serverName);  
			  Thread.sleep(5000);
			  r.browser.findElement(By.xpath("//a[contains(text(),'"+serverName+"')]")).click();
			  WebElement assignConfirm = r.browser.findElement(By.xpath("//input[contains(@value,'确认分配')]"));
			  r.jsClick(assignConfirm);
			  r.browser.switchTo().alert().accept();
		  }
		  
		  catch(Exception e){e.printStackTrace();}
		  
	  }
	  
	  @AfterMethod
	  public void afterMethod() throws Exception {
		  r.afterMethod();
	  }
	
	  @AfterTest
	  public void afterTest() {
		  r.afterTest();
	  }

}
