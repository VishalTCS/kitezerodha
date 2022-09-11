package Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM_Classes.POM1;
import POM_Classes.POM2;
import POM_Classes.POM3;

public class KiteTest extends Base_Class{
 
	//declare all usefull members as global
	POM1 login1;
	POM2 login2;
	POM3 home;
	
	@BeforeClass 
	public void openBrowser() {
		initilizeBrowser();
		
		//all objects of POM class
		login1=new POM1(driver);
		login2=new POM2(driver);
		home=new POM3(driver);
	}
	
	@BeforeMethod
	public void LoginToApp() throws Throwable {
		
		//enter user name
		login1.enterUN(Utility_class.getTD(0, 0)); //DPG458
		
		//enter password
		login1.enterPWD(Utility_class.getTD(0, 1));
		
		//click on login btn
		login1.clickLOGINBTN();
		
		//enter pin
		login2.enterPIN(Utility_class.getTD(0, 2));
		
		//click on continue btn
		login2.clickcntBtn();
	}
	@Test
	public void verifyuserID() throws Throwable {
		Reporter.log("running verify user id",true);
		String actId=home.verifyuserID();
		String expID=Utility_class.getTD(0, 0);
		Assert.assertEquals(actId, expID,"both are different tc is failed");
		
	}
	@AfterMethod
	public void logoutApp() {
		Reporter.log("logout the application",true);
		
	}
	@AfterClass
	public void closeBrowser() {
		Reporter.log("close the app",true);
	}
	
}
