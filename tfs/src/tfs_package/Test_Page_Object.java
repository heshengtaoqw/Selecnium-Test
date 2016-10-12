package tfs_package;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

import webElement.BaiduHomePageElements;

public class Test_Page_Object {
	
	  WebDriver driver = new FirefoxDriver();
	  
	  @Test
	  public void f() {
      driver.get("https://www.baidu.com");	  
	  BaiduHomePageElements b = new BaiduHomePageElements(driver);
	  b.searchField.sendKeys("page Object");
	  b.searchButton.click();
  }
}
