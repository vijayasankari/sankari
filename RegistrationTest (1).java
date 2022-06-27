package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.DataProviders;
import pageObjects.GetStartedPage;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import utility.Log;

public class RegistrationTest extends BaseClass{
	public GetStartedPage getStartedObj = null;
	public HomePage homepageObj = null;
	public RegistrationPage registerObj = null;
	
	
	
	
	@BeforeMethod
	public void setup() {
		launchApp(); 
	}
	
//	@AfterMethod
//	public void tearDown() {
//		getDriver().quit();
//	}
	
	@Test
	public void registerPageURL() throws Throwable {
		Log.startTestCase("registerPageURL");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
		Log.info("user is going to click on Register Link");
		registerObj = homepageObj.clickOnRegisterLink();
		 String actualURL=registerObj.getCurrURL();
		 String expectedURL="https://dsportalapp.herokuapp.com/register";
		 Log.info("Verifying if user is on Registration Page");
		 Assert.assertEquals(actualURL, expectedURL);
		 Log.info("Test Successful");
		 Log.endTestCase("registerPageURL");
		
	}
	
	@Test(priority = 1)
	public void usernameHovermsg() throws Throwable {
		Log.startTestCase("usernameHovermsg");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
		Log.info("user is going to click on Register Link");
		registerObj = homepageObj.clickOnRegisterLink();
		Thread.sleep(2000);
		
		String ActHoverMsg = registerObj.hoverOverUsename();
		String ExpHoverMsg = ("Please fill out this field.");
		Log.info("Verifying hovermessage for UserNAme");
		Assert.assertEquals(ActHoverMsg, ExpHoverMsg);
		Log.info("HoverMessage Validation Successful");
		Log.endTestCase("usernameHovermsg");
		
	}
	
	@Test(priority = 5)
	public void afterClickingSubmitwithAllEmptyfields() throws Throwable {
		Log.startTestCase("afterClickingSubmitwithAllEmptyfields");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
		Log.info("user is going to click on Register Link");
		registerObj = homepageObj.clickOnRegisterLink();
		Thread.sleep(5000);
		registerObj.clickSubmitBtn();
		Log.info("user clicked on Submit btn");
		Thread.sleep(1000);
		registerObj.errorMsgUsename();
		Log.info("ScreenShot to see UserName Error message");
		registerObj.takeScreenShot();
		Log.info("Screenshot taken");
		Log.endTestCase("afterClickingSubmitwithAllEmptyfields");
		
	}
	
//	@Test(priority = 10)
//	public void afterClickingSubmitwithoutPwdCofirm() throws Throwable {
//		Log.startTestCase("afterClickingSubmitwithoutPwdCofirm");
//		getStartedObj= new GetStartedPage();
//		Log.info("user is going on Home Page");
//		homepageObj=getStartedObj.getStarted();
//		Log.info("user is going to click on Register Link");
//		registerObj = homepageObj.clickOnRegisterLink();
//		registerObj.typeUserName("PK1@mail.com");
//		registerObj.typePWD1("abc@123456");
//		registerObj.clickSubmitBtn();
//		Log.info("ScreenShot to see Password Confirm Error message");
//		registerObj.takeScreenShot();
//		Log.info("Screenshot taken");
//		Log.endTestCase("afterClickingSubmitwithoutPwdCofirm");
//		
//	}
	
//	@Test(priority = 15)
//	public void userNamewithNACharcters() throws Throwable {
//		Log.startTestCase("userNamewithNACharcters");
//		getStartedObj= new GetStartedPage();
//		Log.info("user is going on Home Page");
//		homepageObj=getStartedObj.getStarted();
//		Log.info("user is going to click on Register Link");
//		registerObj = homepageObj.clickOnRegisterLink();
//		registerObj.typeUserName("PK##@mail.com");
//		registerObj.typePWD1("abc@123456");
//		registerObj.typePWD2("abc@123456");
//		registerObj.clickSubmitBtn();
//		Log.info("reading Error Message");
//		String ActErrormsg = registerObj.readuseNameNACharErrorMsg();
//		String ExpErrormsg = "Please enter a valid username";
//		Log.info("verifying error message");
//		Assert.assertEquals(ActErrormsg, ExpErrormsg, "Test failed as displayed message doesn't match with Expected message");
//		Log.endTestCase("userNamewithNACharcters");
//		
//	}
	
//	@Test(priority = 20)
//	public void pwdsMismatchErrMasg() throws Throwable {
//		Log.startTestCase("pwdsMismatchErrMasg");
//		getStartedObj= new GetStartedPage();
//		Log.info("user is going on Home Page");
//		homepageObj=getStartedObj.getStarted();
//		Log.info("user is going to click on Register Link");
//		registerObj = homepageObj.clickOnRegisterLink();
//		registerObj.typeUserName("PK3@mail.com");
//		registerObj.typePWD1("abc@1234567");
//		registerObj.typePWD2("abc@123456");
//		registerObj.clickSubmitBtn();
//		Log.info("reading Error Message");
//		String ActErrormsg = registerObj.readuseNameNACharErrorMsg();
//		String ExpErrormsg = "password_mismatch:The two password fields didn’t match.";
//		Log.info("verifying error message");
//		Assert.assertEquals(ActErrormsg, ExpErrormsg, "Test failed as displayed message doesn't match with Expected message");
//		Log.endTestCase("pwdsMismatchErrMasg");
//		
//	}
	
//	@Test(priority = 25)
//	public void pwdsLT8CharErrrMasg() throws Throwable {
//		Log.startTestCase("pwdsLT8CharErrrMasg");
//		getStartedObj= new GetStartedPage();
//		Log.info("user is going on Home Page");
//		homepageObj=getStartedObj.getStarted();
//		Log.info("user is going to click on Register Link");
//		registerObj = homepageObj.clickOnRegisterLink();
//		registerObj.typeUserName("PK3@mail.com");
//		registerObj.typePWD1("abc@123");
//		registerObj.typePWD2("abc@123");
//		registerObj.clickSubmitBtn();
//		Log.info("reading Error Message");
//		String ActErrormsg = registerObj.readuseNameNACharErrorMsg();
//		String ExpErrormsg = "Password should contain atleast 8 characters";
//		Log.info("verifying error message");
//		Assert.assertEquals(ActErrormsg, ExpErrormsg, "Test failed as displayed message doesn't match with Expected message");
//		Log.endTestCase("pwdsLT8CharErrrMasg");
//		
//	}
	
//	@Test(priority =30)
//	public void pwdsOnlyNumErrrMasg() throws Throwable {
//		Log.startTestCase("pwdsLT8CharErrrMasg");
//		getStartedObj= new GetStartedPage();
//		Log.info("user is going on Home Page");
//		homepageObj=getStartedObj.getStarted();
//		Log.info("user is going to click on Register Link");
//		registerObj = homepageObj.clickOnRegisterLink();
//		registerObj.typeUserName("PK3@mail.com");
//		registerObj.typePWD1("123456789");
//		registerObj.typePWD2("123456789");
//		registerObj.clickSubmitBtn();
//		Log.info("reading Error Message");
//		String ActErrormsg = registerObj.readuseNameNACharErrorMsg();
//		String ExpErrormsg = "Your password can’t be entirely numeric.";
//		Log.info("verifying error message");
//		Assert.assertEquals(ActErrormsg, ExpErrormsg, "Test failed as displayed message doesn't match with Expected message");
//		Log.endTestCase("pwdsLT8CharErrrMasg");
//		
//	}
	
		@Test(priority = 35,dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void RegistreTest(String uname, String pswd1,String pswd2) throws Throwable {
		Log.startTestCase("RegistreTest");
		getStartedObj= new GetStartedPage();
		homepageObj=getStartedObj.getStarted();
		Log.info("user is going to click on Register Link");
		registerObj = homepageObj.clickOnRegisterLink();
		Log.info("Enter Username and Password");
		registerObj.typeUserName(uname);
		registerObj.typePWD1(pswd1);
		registerObj.typePWD2(pswd2);
		homepageObj = registerObj.clickSubmitBtnRetHomePage();
		Thread.sleep(3000);
	    Log.info("Verifying Accout Created Success Method");
	    String ActSuccessMsg =  homepageObj.readAccountCreatedMsg();
	    String ExpSuccessMsg = "New Account Created. You are logged in as " +uname;
	    System.out.println("actal msg is :"  +ActSuccessMsg);
	    System.out.println("expected msg is :"  +ExpSuccessMsg);
	    Assert.assertEquals(ActSuccessMsg, ExpSuccessMsg, "Test failed as displayed message doesn't match with Expected message");		
	     
	    Log.info("Login is Sucess");
	    Log.endTestCase("loginTest");
	}
}
