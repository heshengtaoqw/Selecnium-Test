package tfs_package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

public class QualityAssurance {
	
	  ApplicationAssign a = new ApplicationAssign();
	  
	  @BeforeMethod 
	  public void beforeMethod() throws Exception{
		a.r.browser.manage().window().maximize();
	  }
	  
	  @Parameters({"loginName","loginPassword"})
	  @Test
	  public void login(String loginName, String loginPassword)
	  {
		  a.login(loginName, loginPassword);
	  }
	
	  @Parameters({"s"})
	  @Test(dependsOnMethods="login")
	  public void menu(String s) 
	  {
		  a.menu(s);
	  }

	  @Parameters({"salesmanName","groupLeaderName","customerName","customerID"})
	  @Test(dependsOnMethods = "menu")
	  public void filter4Quality(String salesmanName, String groupLeaderName, String customerName, String customerID)

	  {
		  try
		  {
			  a.filter(salesmanName, groupLeaderName, customerName, customerID);
			  Thread.sleep(5000);
			  WebElement Quality = a.r.browser.findElement(By.xpath("//a[contains(text(),'质检')]"));
			  a.r.jsClick(Quality);
		  }
		  catch(Exception e){e.printStackTrace();}
	  }

	  @Parameters({"salesmanName","groupLeaderName","customerName","customerID"})
	  @Test(dependsOnMethods = "filter4Quality")
	  public void doQuality()
	  {
		  try
		  {
			  
			  WebElement checkRule = a.r.browser.findElement(By.id("CheckAllRules"));
			  a.r.jsClick(checkRule);
			  a.r.browser.switchTo().alert().accept();a.r.browser.switchTo().alert().accept();
			  
			  Thread.sleep(5000);
			  WebElement imageMenuButton = a.r.browser.findElement(By.xpath("//a[@href='#tab_FileUpLoad']"));
			  a.r.jsClick(imageMenuButton);
			  
			  WebElement imageCheckRule = a.r.browser.findElement(By.id("CheckAllRules"));
			  a.r.jsClick(imageCheckRule);
			  a.r.browser.switchTo().alert().accept();a.r.browser.switchTo().alert().accept();
			  
			  Thread.sleep(5000);
			  WebElement qualityPass = a.r.browser.findElement(By.xpath("//input[@value='质检完成']"));
			  a.r.jsClick(qualityPass);
			  
			  
			  WebElement qualityComments = a.r.browser.findElement(By.id("check_remark"));
			  JavascriptExecutor j = (JavascriptExecutor) a.r.browser;
			  j.executeScript("document.getElementById('showEmployeeWin').style.display='block';");
			  qualityComments.sendKeys("jfsdkjilfklskldfkjsdlkfskdfs");
			  WebElement Pass = a.r.browser.findElement(By.xpath("//input[@value='通过']"));
			  a.r.jsClick(Pass);
			  a.r.browser.switchTo().alert().accept();
		  }
		  catch(Exception e)
		  {e.printStackTrace();}
		  
	  }
	  
	  @AfterClass
	  public void afterClass() {
	  }

}
