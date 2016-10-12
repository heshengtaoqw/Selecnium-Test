package tfs_package;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.DataProvider;
import org.junit.Assert;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test_Data_ByExcel {
	
	  WebDriver driver;
	
      @DataProvider(name = "searchWords")
      public static Object[][] words() throws Exception
    		  {
    	  		return getTestData("d:\\testdata.csv");
    		  }
	  
	  @Test(dataProvider = "searchWords")
	  public void f(String searchWord1, String searchWord2, String searchResult) 
	  {

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
	    
	  public static Object[][] getTestData(String fileName) throws Exception
	  {
		  List<Object[]> records = new ArrayList<Object[]>();
		  String record;
		  BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
		  file.readLine();
		  while((record=file.readLine())!=null)
		  {
			  String fields[] = record.split(",");
			  records.add(fields);
		  }
		  file.close();
		  Object[][] results = new Object[records.size()][];
		  for(int i = 0; i< records.size(); i++)
		  {
			  results[i] = records.get(i);
		  }
		  return results;
	  }
	  
}