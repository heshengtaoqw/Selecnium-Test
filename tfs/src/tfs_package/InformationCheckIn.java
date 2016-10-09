package tfs_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

public class InformationCheckIn 
{
	
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
	  public void filter4CheckIn(String salesmanName, String groupLeaderName, String customerName, String customerID)
	  {
		  
			  try
			  {
				  a.filter(salesmanName, groupLeaderName, customerName, customerID);
				  Thread.sleep(5000);
				  WebElement CheckIn = a.r.browser.findElement(By.xpath("//input[contains(@value, 'Ã·Ωª')]"));
				  a.r.jsClick(CheckIn);
			  }
			  catch(Exception e){e.printStackTrace();}
		  
	  }
	  
	  @AfterClass
	  public void afterClass() throws Exception {
		  a.afterMethod();
	  }

}
