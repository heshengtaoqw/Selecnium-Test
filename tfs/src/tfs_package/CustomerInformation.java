package tfs_package;

import java.io.File;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import tfs_package.ApplicationAssign;

public class CustomerInformation  {
     	  
	  @BeforeMethod 
	  public void beforeMethod() throws Exception{
		a.r.browser.manage().window().maximize();
	  }
	  
	  ApplicationAssign a = new ApplicationAssign();
	  
	  
	  @Parameters({"loginName","loginPassword"})
	  @Test
	  public void login(String loginName, String loginPassword)
	  {
		  a.login(loginName, loginPassword);
	  }
	  
	  @Parameters({"s"})
	  @Test(dependsOnMethods="login")
	  public void menu(String s) 
	  {
		  a.menu(s);
	  }
	  
	  @Parameters({"salesmanName","groupLeaderName","customerName","customerID"})
	  @Test(dependsOnMethods = "menu")
	  public void filter(String salesmanName, String groupLeaderName, String customerName, String customerID)
	  {
		  try
		  {
			  a.filter(salesmanName, groupLeaderName, customerName, customerID);
			  Thread.sleep(5000);
			  WebElement InformationButton = a.r.browser.findElement(By.xpath("//a[contains(text(),'完善资料')]"));
			  a.r.jsClick(InformationButton);
		  }
		  catch(Exception e){e.printStackTrace();}
	  }

	  @Parameters({"customerSources","phones","educations","marriages","provinces","cities","dists","streets","houseTypes",
		  			"coporationNames", "coporationDepartments", "coporationPositions", "baseSalaries", "sumSalaries", "salaryDays", "years", "months",
		  			"tel1s", "tel2s", "tel3s", "coporationTypes", "jobTypes", "job_industries", "privateCompanys", "province2s", "city2s", "dist2s", "street2s",
		  			"mateNames", "matePhoneNums", "familyNames", "familyPhoneNums", "friendNames", "friendPhoneNums", "workmateNames", "workmatePhoneNums"
	  				})
	  @Test(dependsOnMethods = "filter")
	  public void FillInInformation(String customerSources, String phones, String educations, String marriages, String provinces, String cities, String dists, String streets, String houseTypes,
			  						String coporationNames, String coporationDepartments, String coporationPositions, String baseSalaries, String sumSalaries, String salaryDays, String years, String months,
			  						String tel1s, String tel2s, String tel3s, String coporationTypes, String jobTypes, String job_industries, String privateCompanys, String province2s, String city2s, String dist2s, String street2s,
			  						String mateNames, String matePhoneNums, String familyNames, String familyPhoneNums, String friendNames, String friendPhoneNums, String workmateNames, String workmatePhoneNums  )
	  {
		  //借款信息，个人信息，房产信息
		
       
		  Select customerSource = new Select(a.r.browser.findElement(By.id("Application_loan_source")));
		  WebElement phone = a.r.browser.findElement(By.id("CustContactInfo_cont_mobile1"));
		  Select education = new Select(a.r.browser.findElement(By.id("Customer_highest_education")));
		  Select marriage = new Select(a.r.browser.findElement(By.id("Customer_marriage")));
		  
		  customerSource.selectByVisibleText(customerSources);	  
		  phone.clear();phone.sendKeys(phones);
		  education.selectByVisibleText(educations);  
		  marriage.selectByVisibleText(marriages);
		  
		  JavascriptExecutor j = (JavascriptExecutor)a.r.browser;
		  
		  j.executeScript("document.getElementById('resi_prov_address').style.display='inline';");
		  j.executeScript("document.getElementById('resi_city_address').style.display='inline';");
		  j.executeScript("document.getElementById('resi_dist_address').style.display='inline';");
		  
		  try
		  { 

			  Select province = new Select(a.r.browser.findElement(By.id("resi_prov_address")));
			  Select city = new Select(a.r.browser.findElement(By.id("resi_city_address")));
			  Select dist = new Select(a.r.browser.findElement(By.id("resi_dist_address")));
			  WebElement street = a.r.browser.findElement(By.id("Customer_residence_address"));
			  WebElement liveStreet = a.r.browser.findElement(By.id("isLiveSame"));
			  Select houseType = new Select(a.r.browser.findElement(By.id("Customer_property_type")));
			  WebElement houseLocation = a.r.browser.findElement(By.id("isPropSame"));
			  
			  province.selectByVisibleText(provinces);
			  Thread.sleep(3000); 
			  city.selectByVisibleText(cities);
			  Thread.sleep(3000);	  
			  dist.selectByVisibleText(dists);		  
			  street.clear();street.sendKeys(streets);
			  a.r.jsClick(liveStreet);
			  houseType.selectByVisibleText(houseTypes);
			  Thread.sleep(2000);
			  
			 
			  houseLocation.click(); //按钮第三次才能完全copy地址
		  }
		  catch(Exception e){e.printStackTrace();}
		  
		  
		//*********************************职业信息
		     WebElement coporationName = a.r.browser.findElement(By.id("CustContactInfo_cont_corp_name"));
		     WebElement coporationDepartment = a.r.browser.findElement(By.id("CustContactInfo_cont_corp_dept"));
		     WebElement coporationPosition = a.r.browser.findElement(By.id("CustContactInfo_cont_corp_position"));
		     WebElement baseSalary = a.r.browser.findElement(By.id("Customer_base_salary"));
		     WebElement sumSalary = a.r.browser.findElement(By.id("Customer_sum_salary"));
		     WebElement salaryDay = a.r.browser.findElement(By.id("Customer_salary_day"));
		     WebElement year = a.r.browser.findElement(By.id("entry_time_year"));
		     WebElement month = a.r.browser.findElement(By.id("entry_time_month"));
		     WebElement tel1 = a.r.browser.findElement(By.id("cont_corp_tel1_0"));
		     WebElement tel2 = a.r.browser.findElement(By.id("cont_corp_tel1_1"));
		     WebElement tel3 = a.r.browser.findElement(By.id("cont_corp_tel1_2"));
		     Select coporationType = new Select(a.r.browser.findElement(By.id("Customer_company_type")));
		     Select jobType = new Select(a.r.browser.findElement(By.id("Customer_job_type")));
		     Select job_industry = new Select(a.r.browser.findElement(By.id("Customer_job_industry")));
		     Select privateCompany = new Select(a.r.browser.findElement(By.id("Customer_is_private_company")));
		     
		     coporationName.clear(); coporationName.sendKeys(coporationNames);
		     coporationDepartment.clear(); coporationDepartment.sendKeys(coporationDepartments);
		     coporationPosition.clear(); coporationPosition.sendKeys(coporationPositions);
		     baseSalary.clear(); baseSalary.sendKeys(baseSalaries);
		     sumSalary.clear(); sumSalary.sendKeys(sumSalaries);
		     salaryDay.clear(); salaryDay.sendKeys(salaryDays);
		     year.clear(); year.sendKeys(years);
		     month.clear(); month.sendKeys(months);
		     tel1.clear();tel2.clear();tel3.clear();
		     tel1.sendKeys(tel1s);tel2.sendKeys(tel2s);tel3.sendKeys(tel3s);  
		     coporationType.selectByVisibleText(coporationTypes);
		     jobType.selectByVisibleText(jobTypes);
		     job_industry.selectByVisibleText(job_industries);
		     privateCompany.selectByVisibleText(privateCompanys);
		     
			 j.executeScript("document.getElementById('cont_corp_prov_address').style.display='inline';");
			 j.executeScript("document.getElementById('cont_corp_city_address').style.display='inline';");
			 j.executeScript("document.getElementById('cont_corp_dist_address').style.display='inline';");
			 
			 try
			  { 
				  Select province2 = new Select(a.r.browser.findElement(By.id("cont_corp_prov_address")));
				  Select city2 = new Select(a.r.browser.findElement(By.id("cont_corp_city_address")));
				  Select dist2 = new Select(a.r.browser.findElement(By.id("cont_corp_dist_address")));
				  WebElement street2 = a.r.browser.findElement(By.id("CustContactInfo_cont_corp_address"));
				  province2.selectByVisibleText(province2s);
				  Thread.sleep(3000);
				  city2.selectByVisibleText(city2s);
				  Thread.sleep(3000);
				  dist2.selectByVisibleText(dist2s);
				  street2.clear();street2.sendKeys(street2s);
				 
				 j.executeScript("document.getElementById('resi_prov_address').style.display='none';");
				 j.executeScript("document.getElementById('resi_city_address').style.display='none';");
				 j.executeScript("document.getElementById('resi_dist_address').style.display='none';");
				 j.executeScript("document.getElementById('cont_corp_prov_address').style.display='none';");
				 j.executeScript("document.getElementById('cont_corp_city_address').style.display='none';");
				 j.executeScript("document.getElementById('cont_corp_dist_address').style.display='none';");
				 j.executeScript("document.getElementById('cont_corp_dist_address').style.display='none';");
			  }
			 catch(Exception e){e.printStackTrace();}
			 
			 
			//*********************************基础人信息
			 
			 try{
				 WebElement mateName = a.r.browser.findElement(By.id("PeiouContactInfo_cont_name"));
			     WebElement matePhoneNum = a.r.browser.findElement(By.id("PeiouContactInfo_cont_mobile1"));
			     WebElement familyName = a.r.browser.findElement(By.id("ZxqsContactInfo_cont_name"));
			     WebElement familyPhoneNum  = a.r.browser.findElement(By.id("ZxqsContactInfo_cont_mobile1"));
			     WebElement friendName = a.r.browser.findElement(By.id("QspyContactInfo_cont_name"));
			     WebElement friendPhoneNum = a.r.browser.findElement(By.id("QspyContactInfo_cont_mobile1"));
			     WebElement workmateName = a.r.browser.findElement(By.id("TsContactInfo_cont_name"));
			     WebElement workmatePhoneNum = a.r.browser.findElement(By.id("TsContactInfo_cont_mobile1"));
			     WebElement checkInformation = a.r.browser.findElement(By.id("CheckAllRules"));
			     WebElement loc1 = a.r.browser.findElement(By.xpath("//a[contains(text(),'返回列表')]"));
			     JavascriptExecutor scrollbar = (JavascriptExecutor) a.r.browser;
			     
			     
			     mateName.clear();mateName.sendKeys(mateNames);
			     matePhoneNum.clear();matePhoneNum.sendKeys(matePhoneNums);
			     familyName.clear();familyName.sendKeys(familyNames);
			     familyPhoneNum.clear();familyPhoneNum.sendKeys(familyPhoneNums);
			     friendName.clear();friendName.sendKeys(friendNames);
			     friendPhoneNum.clear();friendPhoneNum.sendKeys(friendPhoneNums);
			     workmateName.clear();workmateName.sendKeys(workmateNames);
			     workmatePhoneNum.clear();workmatePhoneNum.sendKeys(workmatePhoneNums);
			     
			     scrollbar.executeScript("arguments[0].scrollIntoView(false)", loc1);
			     Thread.sleep(1000);
			     File f1 = ((TakesScreenshot) a.r.browser).getScreenshotAs(OutputType.FILE);
			     FileUtils.copyFile(f1, new File("D:\\SVNLocal\\tfs\\screenshot\\CustomerInformation\\CustomerInformation.png"));
			     checkInformation.click();
			     Thread.sleep(1000);
			     a.r.browser.switchTo().alert().accept();
		
			 }
		     catch(Exception e)
		     {e.printStackTrace();}	     
			 
	  }
	
	  @AfterMethod
	  public void afterMethod() throws Exception{
		  a.afterMethod();
		
	  }
	
	  @AfterTest
	  public void afterTest() {
		  a.afterTest();
	  }

}
