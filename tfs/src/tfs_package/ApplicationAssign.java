package tfs_package;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import tfs_package.Register;

public class ApplicationAssign {
	
	  Register r = new Register();

	  @Parameters({"loginName","loginPassword"})
	  @Test
	  public void login(String loginName, String loginPassword)
	  {
		  r.login(loginName, loginPassword);
	  }
	  
	  @Test(dependsOnMethods="login")
	  public void menu() 
	  {
		  WebElement menuButton = r.browser.findElement(By.xpath("//span[contains(text(),'借款分配')]"));
		  r.jsClick(menuButton);
		  //JavascriptExecutor js1 = (JavascriptExecutor) browser;
	      //js1.executeScript("arguments[0].click();", menuButton);
		  
		  //Assert.assertEquals(browser.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div/div/div[1]/label")).getText(), "借款申请/借款登记");
		  //Assert.assertFalse(browser.findElement(By.name("business_dept_name")).isEnabled());
	  }
	  
	  @Parameters({"loginName","loginPassword"})
	  @Test(dependsOnMethods = "menu")
	  public void filter()
	  {
		  System.out.println(r.browser.getCurrentUrl());
		  WebElement custNameField = r.browser.findElement(By.id("cust_name"));
		  WebElement idCardField = r.browser.findElement(By.id("id_card"));
		  WebElement salesmanNameField = r.browser.findElement(By.id("salesman_name"));
		  WebElement groupLeaderNameField = r.browser.findElement(By.id("group_leader_name"));
		  
		  custNameField.sendKeys("林华");
		  idCardField.sendKeys("512501197506045175");
		  
		  try
		  {
			  salesmanNameField.sendKeys("测试肖六:XS006");
			  Thread.sleep(5000);
			  r.browser.findElement(By.xpath("//a[contains(text(),'测试肖六:XS006')]")).click();;
			  
			  groupLeaderNameField.sendKeys("测试肖二:XS002");
			  Thread.sleep(5000);
			  r.browser.findElement(By.xpath("//a[contains(text(),'测试肖二:XS002')]")).click();;
			  
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
	  
	  @AfterMethod
	  public void afterMethod() throws Exception {
		  r.afterMethod();
	  }
	
	  @AfterTest
	  public void afterTest() {
		  r.afterTest();
	  }

}
