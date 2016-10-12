package tfs_package;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.DataProvider;
import org.junit.Assert;

public class Test_Data_Provider {
	
      @DataProvider(name = "searchWords")
      public static Object[][] words()
    		  {
    	  		return new Object[][]
    	  				{
    	  					{"òùòðÏÀ","Ö÷ÑÝ","Âõ¿Ë¶û"},
    	  					{"³¬ÈË","µ¼ÑÝ","ÌÆÄÉ"},
    	  					{"Éú»¯Î£»ú","±à¾ç","11252"}
    	  				};
    		  }
	
	  WebDriver driver;
	  @Test(dataProvider = "searchWords")
	  public void f(String searchWord1, String searchWord2, String searchResult) {
		  try
		  {
			  driver = new FirefoxDriver();
			  driver.get("https://www.baidu.com");
			  WebElement e = driver.findElement(By.id("kw"));
			  WebElement search = driver.findElement(By.id("su"));
			  e.sendKeys(searchWord1 + "" + searchWord2);
			  search.click();
			  Thread.sleep(2000);
			  Assert.assertTrue(driver.getPageSource().contains(searchResult));
			  driver.quit();
			  
		  }
		  catch(Exception e) {e.printStackTrace();}
		  
		  
	  }
}
