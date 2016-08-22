package automation;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class NewTest {
  @Test
  public void f() {
	  WebDriver browser = new FirefoxDriver();
	  browser.get("https://www.baidu.com");
  }
}
