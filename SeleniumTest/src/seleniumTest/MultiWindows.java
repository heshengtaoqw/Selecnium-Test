package seleniumTest;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;

public class MultiWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver browser = new FirefoxDriver();
		browser.get("https://www.baidu.com");
		WebElement findDefaultPage = browser.findElement(By.id("setf"));
		findDefaultPage.click();
		
		String [] handles = new String[browser.getWindowHandles().size()];
		browser.getWindowHandles().toArray(handles); //��getWindowHandles List�������ֵ�ŵ� handles��array�� �������棬
		
		for(int i=0; i < handles.length;i++)
		{
			System.out.println(handles[i]);
		}
		
		WebDriver subBrowser = browser.switchTo().window(handles[1]);
		WebElement subBrowserHomePage = subBrowser.findElement(By.linkText("�ٶ���ҳ"));
		subBrowserHomePage.click();
		
		
	}

}
