package seleniumTestLoginModule;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

class LoginDetail

{	
		
	public void case1(String s) throws Exception 
	{
		
		if(s.equals("������д�ֻ�/����/�û���"))
		{
			System.out.println("Case1: ��û�������û���������ʱ������½������ʾ�� "
	    	+ s + "---Pass");
		}
		else
		{
			System.out.println("Case failed, " + "CurrentText is " + s);
		}
	}
	
	public void case2(String s) throws Exception
	{
		if(s.equals("������д����"))
		{
			System.out.println("Case2: ������Ϊ��ʱ������½������ʾ�� "
	    	+ s + "---Pass");
		}
		else
		{
			System.out.println("Case failed, " + "CurrentText is " + s);
		}
	}
	
	public void case3(String s) throws Exception
	{
		if(s.equals("������д�ֻ�/����/�û���"))
		{
			System.out.println("Case3: �������˺�Ϊ�յ�ʱ������½������ʾ��" 
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
		// TODO �Զ����ɵķ������
	
		
		
		LoginDetail loginDetail = new LoginDetail();
		WebDriver browser = new FirefoxDriver();
		browser.get("https://www.baidu.com");
		WebElement findLoginButton = browser.findElement(By.linkText("��¼"));
		findLoginButton.click();
		
		Thread.sleep(3000);
		
		WebElement findAccountName = browser.findElement(By.id("TANGRAM__PSP_8__userName"));
		WebElement findPassword = browser.findElement(By.id("TANGRAM__PSP_8__password"));
		WebElement findSubmit = browser.findElement(By.id("TANGRAM__PSP_8__submit"));
		
		//case 1 ��û�������û���������ʱ������½
		findSubmit.submit();
		String s = browser.findElement(By.id("TANGRAM__PSP_8__error")).getText();
		loginDetail.case1(s);
		Thread.sleep(5000);		
		
		
		//case2 ������Ϊ�յ�ʱ������½
		findAccountName.clear();
		findPassword.clear();
		findAccountName.sendKeys("aa7405788");
		findPassword.sendKeys("");
		findSubmit.submit();
		Thread.sleep(5000);
		s = browser.findElement(By.id("TANGRAM__PSP_8__error")).getText();
		loginDetail.case2(s);
		
		
		//case3 ���˺�Ϊ�յ�ʱ������½
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
