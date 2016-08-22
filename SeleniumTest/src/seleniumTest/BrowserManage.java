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
		
		System.out.println("当前cookie集合的数量为 " + cookie.size());
		System.out.println("");
		for(int i=0;i<allCookie.length;i++)
		{
			System.out.println("第" + (i + 1) + "个cookie的各项属性为：");
			System.out.println("cookie名称  " + allCookie[i].getName());
			System.out.println("cookie值  " + allCookie[i].getDomain());
			System.out.println("cookie所在域  " + allCookie[i].getDomain());
			System.out.println("cookie路径 " + allCookie[i].getPath());
			System.out.println("cookie过期时间 - " + allCookie[i].getExpiry());
			
		}
		
		Timeouts timeouts = browser.manage().timeouts();
		timeouts.implicitlyWait(30, java.util.concurrent.TimeUnit.SECONDS); //脚本在查找元素时的最大等待时间设置为30s
		timeouts.setScriptTimeout(30, java.util.concurrent.TimeUnit.SECONDS); //脚本异步执行的超时时间设置为30s
		timeouts.pageLoadTimeout(30, java.util.concurrent.TimeUnit.SECONDS); //页面跳转或刷新的超时时间设置为30s
		
	}

}
