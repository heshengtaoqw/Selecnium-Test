package loginBaidu;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class TestLoginBaidu {
	

	public static void case1(String s)
	{
		
		if(s.equals("������д�ֻ�/����/�û���"))
		{
			System.out.println("case1�� ��û�������û�������ʱ����ʾ�� " + s + "---Pass");
		}
		else
		{
			System.out.println("��ǰ�ı�Ϊ�� " + s);
		}
	}
	
	public static void case2(String s)
	{
		if(s.equals("������д����"))
		{
			System.out.println("case2�� ��û����������ʱ����ʾ�� " + s + "---Pass");
		}
		else
		{
			System.out.println("��ǰ�ı�Ϊ�� " + s);
		}
	}
	
	public static void case3(String s)
	{
		if(s.equals("������󣬿������Զ��ŵ�¼ ,�����һ�����"))
		{
			System.out.println("case2�� ��û����������ʱ����ʾ�� " + s + "---Pass");
		}
		else
		{
			System.out.println("��ǰ�ı�Ϊ�� " + s);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriver browser = new FirefoxDriver();
		browser.get("https://www.baidu.com");
		WebElement findLoginButton = browser.findElement(By.linkText("��¼"));
		findLoginButton.click();
		WebElement findSubmitButton = browser.findElement(By.id("TANGRAM__PSP_8__submit"));
		WebElement findUserName = browser.findElement(By.id("TANGRAM__PSP_8__userName"));
		WebElement findPassword = browser.findElement(By.id("TANGRAM__PSP_8__password"));
		
		
	
		//case1
		findSubmitButton.submit();
		Thread.sleep(5000);
		String s = browser.findElement(By.id("TANGRAM__PSP_8__error")).getText();
		case1(s);
		
		//case2
		findUserName.sendKeys("aa740578857");
		findPassword.sendKeys("");
		findSubmitButton.submit();
		Thread.sleep(5000);
		s = browser.findElement(By.id("TANGRAM__PSP_8__error")).getText();
		case2(s);
		
		//case3
		findUserName.clear();
		findPassword.clear();
		findUserName.sendKeys("aa740578857");
		findPassword.sendKeys("44411");
		findSubmitButton.submit();
		Thread.sleep(5000);
		findSubmitButton.submit();
		Thread.sleep(5000);
		s = browser.findElement(By.id("TANGRAM__PSP_8__error")).getText();
		case3(s);
		
	}
}
