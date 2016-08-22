/*
*. TestNG��suite/test/test method��������
* ����TestNG�ɼ��ֲ�ͬ������

    * ʹ��testng.xml�ļ�
    * ʹ��ant
    * ��������
*
1. before������after����    �������㹻�ḻ�Ĳ����������ڿ���
2. dependsOnGroups/dependsOnMethods �ṩ�����������ƣ��������ϸ����ִ��˳��
3. DataProvider ʹ�ö�ͬһ�������Ĳ��Ը��Ǳ�ķǳ����ɣ��ǳ��ʺϽ��б߽���ԣ�ֻҪ�������ֲ������ݾͿ������һ�����Է������и���
4. expectedExceptions ʹ���쳣���Ա�ķǳ�����
5. invocationCount/threadPoolSize ���ڿ��Լ򵥵�ֱ�ӽ��ж��̲߳����ˣ����������junit�ĳ����������junit���Ǹ�����System.exist(0)...
6. timeOut ���ڲ�������Ȼ���ֹ�ǿ�йرղ��ԣ�TestNG���̫�ܵ���
*/

package testNG_Baidu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.Parameters;

public class TestNG_Basic {
	
  //@@@Test  --���һ����򷽷���Ϊ���Ե�һ����
  //���������� @Test(dataProvider = "DataProviderName")
  //@Test(dataProvider = "DataProviderName")   @Test(dependsOnMethods = 'MethodName') @Test(dependsOnGroups = 'groupsName')
  //@Test(enabled = 'fault' or 'ture')  
  //@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp="NullPoint") --���Է��������׳����쳣�б����û���쳣�����׳��Ĳ����б��е��κ�һ������ǰ�����������Ϊʧ��.
  //@Test(threadPoolSize = 3, invocationCount = 10,  timeOut = 10000)
  //@Test(groups = 'groupName')  -- 1���������Զ���ɶ��groups @Test(groups = { "functest", "checkintest" })  
	@Test(dependsOnMethods = "f", groups = "group1")
	  public void g()
	  {
		  System.out.println("g() will be ran after f() completes");
	  }
	
	
	@Test(groups = "group1")
		public void f() 
	  {
		  System.out.println("test");
	  }
  
  
  /*
   TestNG����ִ�и��ӵĲ��Է������顣���������������������飬���ҿ���ָ����������������顣
	Ȼ��TestNG���Ա����ã�����Ҫ�����ĳЩ������ų������ķ��顣
	�⽫�ṩ�������ֲ��Ե�����ԣ��������������������ͬ�Ĳ���װ�ò���Ҫ���±��롣
	group = "functest" ��3��testMethod��testMethod1��testMethod2��testMethod3��
	group = "checkintest" ��2��testMethod(testMethod1, testMethod2)
		public class Test1 
		{ 
		  @Test(groups = { "functest", "checkintest" }) 
		  public void testMethod1() { 
		  } 
		  @Test(groups = {"functest", "checkintest"} ) 
		  public void testMethod2() { 
		  } 
		  @Test(groups = { "functest" }) 
		  public void testMethod3() { 
		  } 
		}
			
		//---------
			@Test 
			public class Test1 
			{ 
			  @Test(groups = { "windows.checkintest" })  
			  public void testWindowsOnly() { 
			  } 
			  @Test(groups = {"linux.checkintest"} ) 
			  public void testLinuxOnly() { 
			  } 
			  @Test(groups = { "windows.functest" ) 
			  public void testWindowsToo() { 
			  } 
			} 	
			�����ʹ�������testng.xml�ļ�ֻ����Windows������
			<test name="Test1"> 
			  <groups> 
			    <run> 
			      <include name="windows.*"/> 
			    </run> 
			  </groups> 
			  <classes> 
			    <class name="example1.Test1"/> 
			  </classes> 
			</test> 
		//----------
   */
  //----------------------------------------------------------------------
  
  
  //@@@BeforeMethod --��ע�͵ķ������ڲ�������ǰ����
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Test will be launched first before every method");
  }
  //----------------------------------------------------------------------
  
  
  //@@@AfterMethod --��ע�͵ķ������ڲ������к�����
  @AfterMethod
  public void afterMethod() {
	  System.out.println("This will be launched after every method");
	  System.out.println("");
  }
  //-----------------------------------------------------------------------
  
  
  //@DataProvider  --���һ����������Ϊ���Է����ṩ����
  //������name
  //��ע�͵ķ������뷵��Object[][], ����ÿ��Object[]����ָ��Ϊ������Է����Ĳ����б������DataProvider��������@Test������Ҫʹ��һ���͵�ǰע����ͬ���Ƶ�dataProvider����
  //Ĭ�ϣ����ڵ�ǰ��������Ļ����в���data provider��������뽫data provider���õ���һ�����У���Ҫ�����data provider��������Ϊ��̬����������dataProviderClass������ָ�����ĸ����п����ҵ����������
  //@Test(dataProvider = "create", dataProviderClass = StaticProvider.class)
  @DataProvider(name = "user")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  
  @Test(dataProvider = "user", groups = "group2")
  public void c(int a, String b)
  {
	  System.out.println("a:" + a + "  " +"b:" + b);
  }
  //-----------------------------------------------------------------------
  
  
  //@Parameters  --������δ��ݲ�����@Test����
  //������value
  //test1����XML���渳ֵ��
  /*
   <suite name="My suite">
  	<parameter name="test1"  value="Cedric"/>
  	<test name="Simple example">
  <--  -->
   */
  
  @Test(groups = "group3")
  @Parameters("test1")
  public void paraTest(String test1){
      System.out.println("This is " + test1);
  }
  
  //------------------------------------------------------------------------
  
  
  //@BeforeClass  --��ע�͵ķ������ڵ�ǰ��ĵ�һ�����Է�������ǰ���С�
  @BeforeClass 
  public void beforeClass() {
	  System.out.println("This will be launched before the first test method runs");
	  System.out.println("");
  }
  //------------------------------------------------------------------------
  
  
  //@AfterClass  --��ע�͵ķ������ڵ�ǰ������в��Է������ú�����
  @AfterClass
  public void afterClass() {
	  System.out.println("");
	  System.out.println("This will be launched after all test methods complete");
  }
  //-------------------------------------------------------------------------
  
  
  //@BeforeTest  --��ע�͵ķ������ڲ�������ǰ����
  @BeforeTest
  public void beforeTest() {
	  System.out.println("This will be launched before test");
	  System.out.println("");
  }

  //@AfterTest  --��ע�͵ķ������ڲ������к�����
  @AfterTest
  public void afterTest() {
	  System.out.println("");
	  System.out.println("This will be launched after test");
  }
  //----------------------------------------------------------------------------
  
  
  
}
