/*
*. TestNG有suite/test/test method三个级别
* 调用TestNG由几种不同方法：

    * 使用testng.xml文件
    * 使用ant
    * 从命令行
*
1. before方法和after方法    带来了足够丰富的测试生命周期控制
2. dependsOnGroups/dependsOnMethods 提供了依赖检查机制，并可以严格控制执行顺序
3. DataProvider 使得对同一个方法的测试覆盖变的非常轻松，非常适合进行边界测试，只要给出多种测试数据就可以针对一个测试方法进行覆盖
4. expectedExceptions 使得异常测试变的非常轻松
5. invocationCount/threadPoolSize 终于可以简单的直接进行多线程测试了，这个绝对是junit的超级弱项，回想junit中那个万恶的System.exist(0)...
6. timeOut 终于不用死等然后手工强行关闭测试，TestNG想的太周到了
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
	
  //@@@Test  --标记一个类或方法作为测试的一部分
  //有以下属性 @Test(dataProvider = "DataProviderName")
  //@Test(dataProvider = "DataProviderName")   @Test(dependsOnMethods = 'MethodName') @Test(dependsOnGroups = 'groupsName')
  //@Test(enabled = 'fault' or 'ture')  
  //@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp="NullPoint") --测试方法期望抛出的异常列表。如果没有异常或者抛出的不是列表中的任何一个，当前方法都将标记为失败.
  //@Test(threadPoolSize = 3, invocationCount = 10,  timeOut = 10000)
  //@Test(groups = 'groupName')  -- 1个方法可以定义成多个groups @Test(groups = { "functest", "checkintest" })  
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
   TestNG容许执行复杂的测试方法分组。不仅可以申明方法属于组，而且可以指定分组包含其他分组。
	然后TestNG可以被调用，并被要求包含某些分组和排除其他的分组。
	这将提供怎样划分测试的最大弹性，并且如果想运行两个不同的测试装置不需要重新编译。
	group = "functest" 有3个testMethod（testMethod1，testMethod2，testMethod3）
	group = "checkintest" 有2个testMethod(testMethod1, testMethod2)
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
			你可以使用下面的testng.xml文件只启动Windows方法：
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
  
  
  //@@@BeforeMethod --被注释的方法将在测试运行前运行
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Test will be launched first before every method");
  }
  //----------------------------------------------------------------------
  
  
  //@@@AfterMethod --被注释的方法将在测试运行后运行
  @AfterMethod
  public void afterMethod() {
	  System.out.println("This will be launched after every method");
	  System.out.println("");
  }
  //-----------------------------------------------------------------------
  
  
  //@DataProvider  --标记一个方法用于为测试方法提供数据
  //属性有name
  //被注释的方法必须返回Object[][], 其中每个Object[]可以指派为这个测试方法的参数列表。从这个DataProvider接收数据@Test方法需要使用一个和当前注释相同名称的dataProvider名称
  //默认，将在当前类或者它的基类中查找data provider。如果你想将data provider放置到另一个类中，需要将这个data provider方法设置为静态方法，并在dataProviderClass属性中指定在哪个类中可以找到这个方法。
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
  
  
  //@Parameters  --描述如何传递参数给@Test方法
  //属性有value
  //test1是在XML里面赋值的
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
  
  
  //@BeforeClass  --被注释的方法将在当前类的第一个测试方法调用前运行。
  @BeforeClass 
  public void beforeClass() {
	  System.out.println("This will be launched before the first test method runs");
	  System.out.println("");
  }
  //------------------------------------------------------------------------
  
  
  //@AfterClass  --被注释的方法将在当前类的所有测试方法调用后运行
  @AfterClass
  public void afterClass() {
	  System.out.println("");
	  System.out.println("This will be launched after all test methods complete");
  }
  //-------------------------------------------------------------------------
  
  
  //@BeforeTest  --被注释的方法将在测试运行前运行
  @BeforeTest
  public void beforeTest() {
	  System.out.println("This will be launched before test");
	  System.out.println("");
  }

  //@AfterTest  --被注释的方法将在测试运行后运行
  @AfterTest
  public void afterTest() {
	  System.out.println("");
	  System.out.println("This will be launched after test");
  }
  //----------------------------------------------------------------------------
  
  
  
}
