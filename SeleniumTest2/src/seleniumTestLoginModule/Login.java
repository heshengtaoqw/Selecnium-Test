package seleniumTestLoginModule;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

class LoginDetail

{	
		
	public void case1(String s) throws Exception 
	{
		
		if(s.equals("请您填写手机/邮箱/用户名"))
		{
			System.out.println("Case1: 当没有输入用户名和密码时候点击登陆，将提示： "
	    	+ s + "---Pass");
		}
		else
		{
			System.out.println("Case failed, " + "CurrentText is " + s);
		}
	}
	
	public void case2(String s) throws Exception
	{
		if(s.equals("请您填写密码"))
		{
			System.out.println("Case2: 当密码为空时候点击登陆，将提示： "
	    	+ s + "---Pass");
		}
		else
		{
			System.out.println("Case failed, " + "CurrentText is " + s);
		}
	}
	
	public void case3(String s) throws Exception
	{
		if(s.equals("请您填写手机/邮箱/用户名"))
		{
			System.out.println("Case3: 当输入账号为空的时候点击登陆，将提示：" 
			+ s + "---Pass");
		}
		else
		{
			System.out.println("Current Text is " + s);
		}
	}

}
	
public class Login {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
	
		
		
		LoginDetail loginDetail = new LoginDetail();
		WebDriver browser = new FirefoxDriver();
		browser.get("https://www.baidu.com");
		WebElement findLoginButton = browser.findElement(By.linkText("登录"));
		findLoginButton.click();
		
		Thread.sleep(3000);
		
		WebElement findAccountName = browser.findElement(By.id("TANGRAM__PSP_8__userName"));
		WebElement findPassword = browser.findElement(By.id("TANGRAM__PSP_8__password"));
		WebElement findSubmit = browser.findElement(By.id("TANGRAM__PSP_8__submit"));
		
		//case 1 当没有输入用户名和密码时候点击登陆
		findSubmit.submit();
		String s = browser.findElement(By.id("TANGRAM__PSP_8__error")).getText();
		loginDetail.case1(s);
		Thread.sleep(5000);		
		
		
		//case2 当密码为空的时候点击登陆
		findAccountName.clear();
		findPassword.clear();
		findAccountName.sendKeys("aa7405788");
		findPassword.sendKeys("");
		findSubmit.submit();
		Thread.sleep(5000);
		s = browser.findElement(By.id("TANGRAM__PSP_8__error")).getText();
		loginDetail.case2(s);
		
		
		//case3 当账号为空的时候点击登陆
		findAccountName.clear();
		findPassword.clear();
		findAccountName.sendKeys("");
		findPassword.sendKeys("abc123456");
		findSubmit.submit();
		Thread.sleep(5000);
		findSubmit.submit();
		s = browser.findElement(By.id("TANGRAM__PSP_8__error")).getText();
		loginDetail.case3(s);
		
		browser.quit();
	}
}
