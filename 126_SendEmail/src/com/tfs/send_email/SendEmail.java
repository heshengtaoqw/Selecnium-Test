package com.tfs.send_email;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

public class SendEmail {
	
		WebDriver browser = new FirefoxDriver();
	  
	  @Test
	  public void open() 
	  {
		  browser.get("https://exmail.qq.com");
	  }
	  
	  @Parameters({"username","password"})
	  @Test
	  public void login(String username, String password)
	  {
		  WebElement login = browser.findElement(By.linkText("µÇÂ¼"));
		  login.click();
		  WebElement usernameField = browser.findElement(By.id("inputuin"));
		  WebElement passwordField = browser.findElement(By.id("pp"));
		  usernameField.sendKeys(username);
		  passwordField.sendKeys(password);
	  }
	  
  
}
