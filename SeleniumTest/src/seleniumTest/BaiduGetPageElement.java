package seleniumTest;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.firefox.*;


public class BaiduGetPageElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver browser = new FirefoxDriver();
		browser.get("https://www.baidu.com");
		WebElement findSearchButton = browser.findElement(By.id("su"));
		String s = findSearchButton.getAttribute("value");
		System.out.println(s);
		
		WebElement findNewsButton = browser.findElement(By.name("tj_trnuomi"));
		String f = findNewsButton.getText();
		System.out.println(f);
		
		String title = browser.getTitle();
		System.out.println(title);
		
		String url = browser.getCurrentUrl();
		System.out.println(url);
		
		WebElement findTextFiled = browser.findElement(By.id("kw"));
		Boolean bDisplay = findTextFiled.isDisplayed();
		Boolean bEditable = findTextFiled.isEnabled();
		System.out.println("TextField is displayed " + bDisplay);
		System.out.println("TextField is Editabled " + bEditable);
		
		browser.findElement(By.linkText("µÇÂ¼")).click();
		WebElement findCheckBox = browser.findElement(By.id("TANGRAM__PSP_8__memberPass"));
		Boolean bSelect = findCheckBox.isSelected();
		System.out.println("CheckBox is selected " + bSelect);
		
		browser.close();
	}

}
