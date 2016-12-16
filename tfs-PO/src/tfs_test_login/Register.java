package tfs_test_login;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.*;
import org.testng.annotations.Parameters;

import tfs_Web_Page.HomePageWebElement;
import tfs_Web_Page.RegisterPageWebElement;

public class Register {
	
	  HomePageWebElement hpwe = new HomePageWebElement();
	  RegisterPageWebElement rpwe = new RegisterPageWebElement(hpwe.driver);
	  
      @Parameters({"loginName","loginPassword","loginURL","homeURL"})	
	  @Test
	  public void login(String loginName, String loginPassword, String loginURL, String homeURL) throws Exception
	  {
    	  
		  hpwe.load(loginURL);
		  hpwe.authentication(loginName, loginPassword);
		  hpwe.jsClick(hpwe.loginButton);
		  Thread.sleep(3000);
		  hpwe.load(homeURL);
		  Thread.sleep(3000);
	  }
      
      @Test(dependsOnMethods="login")
      public void register() throws Exception
      {	  
    	  hpwe.jsClick(rpwe.menuButton);
      }
	
     
}
