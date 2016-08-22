package seleniumTest;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver.*;


public class BrowserManage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver browser = new FirefoxDriver();
		browser.get("https://www.baidu.com");
		java.util.Set<Cookie> cookie = browser.manage().getCookies();
		Cookie[] allCookie = new Cookie[cookie.size()];
		cookie.toArray(allCookie);
		
		System.out.println("��ǰcookie���ϵ�����Ϊ " + cookie.size());
		System.out.println("");
		for(int i=0;i<allCookie.length;i++)
		{
			System.out.println("��" + (i + 1) + "��cookie�ĸ�������Ϊ��");
			System.out.println("cookie����  " + allCookie[i].getName());
			System.out.println("cookieֵ  " + allCookie[i].getDomain());
			System.out.println("cookie������  " + allCookie[i].getDomain());
			System.out.println("cookie·�� " + allCookie[i].getPath());
			System.out.println("cookie����ʱ�� - " + allCookie[i].getExpiry());
			
		}
		
		Timeouts timeouts = browser.manage().timeouts();
		timeouts.implicitlyWait(30, java.util.concurrent.TimeUnit.SECONDS); //�ű��ڲ���Ԫ��ʱ�����ȴ�ʱ������Ϊ30s
		timeouts.setScriptTimeout(30, java.util.concurrent.TimeUnit.SECONDS); //�ű��첽ִ�еĳ�ʱʱ������Ϊ30s
		timeouts.pageLoadTimeout(30, java.util.concurrent.TimeUnit.SECONDS); //ҳ����ת��ˢ�µĳ�ʱʱ������Ϊ30s
		
	}

}
