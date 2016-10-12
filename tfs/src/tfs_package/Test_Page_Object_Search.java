package tfs_package;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import webElement.BaiduHomePage_Search;

public class Test_Page_Object_Search {
  @Test
  public void f() {
	  BaiduHomePage_Search bai = new BaiduHomePage_Search();
	  bai.load();
	  bai.search();
  }
}
