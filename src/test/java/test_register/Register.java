package test_register;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import data.Data;
import driver.Driver;
import pages.BasePage;
import pages.LoginPage;
import pages.RegisterPage;
import report.Report;

public class Register {
	/*** DRIVER ***/
	private WebDriver driver = null;

	/*** PAGES ***/
	private BasePage basePage = null;
	private RegisterPage registerPage = null;
	private LoginPage loginPage = null;

	/*** VARIABLES ***/
	private static final String URL = "https://www.demoblaze.com/index.html";
	private String text_alert = null;

	/*** REPORTS ***/
	private ExtentReports report = null;

	/*** METHODS ***/
	// Pre-Config
	@BeforeMethod
	public void configurateTest() {
		driver = Driver.configurate();

		report = Report.configurate();

		basePage = new BasePage(driver);
		basePage.navigateTo(URL);

		registerPage = new RegisterPage();
		loginPage = new LoginPage();
	}

	// Tests
	@Test(dataProvider = "Register", dataProviderClass = Data.class, priority = 1)
	public void register(String usr, String pass) {
		ExtentTest test = report.createTest("Register Test");

		test.log(Status.INFO, "REGISTER TEST STARTED SUCCESSFULLY");
		System.out.println("\n***REGISTER TEST STARTED SUCCESSFULLY***");
		
		registerPage.clickRegisterBtn();
		test.pass("User clicked register button");

		registerPage.completeUsername(usr);
		test.pass("User completed username");

		registerPage.completePassword(pass);
		test.pass("User completed password");

		registerPage.clickRegisterBtn2();
		test.pass("User clicked register button");

		test.info("Register Data User Completed");

		try {

			text_alert = registerPage.getAlertText();
			System.out.println("Alert: " + text_alert);
			test.pass("Alert text saved");

			registerPage.acceptAlert();
			test.pass("User acepted alert");

			assertEquals("Sign up successful.", text_alert);
			assertTrue(loginPage.isLoginBtnVisible());
			test.pass("Register test OK");
			test.log(Status.INFO, "REGISTER TEST COMPLETED SUCCESSFULLY");
			System.out.println("***REGISTER TEST COMPLETED SUCCESSFULLY***");

		} catch (AssertionError e) {
			test.addScreenCaptureFromPath("screenshot.png");
			test.fail("Register test NO OK");
			test.log(Status.INFO, "REGISTER TEST COMPLETED UNSUCCESSFULLY");
			System.out.println("***REGISTER TEST COMPLETED UNSUCCESSFULLY***");

		}

	}

	@Test(dataProvider = "RegisterUsernameExistent", dataProviderClass = Data.class, priority = 2)
	public void registerUsrExistent(String usr, String pass) {
		ExtentTest test = report.createTest("Register Username Existent Test");

		test.log(Status.INFO, "REGISTER USERNAME EXISTENT TEST STARTED SUCCESSFULLY");
		System.out.println("\n***REGISTER USERNAME EXISTENT TEST STARTED SUCCESSFULLY***");
		
		registerPage.clickRegisterBtn();
		test.pass("User clicked register button");

		registerPage.completeUsername(usr);
		test.pass("User completed username");

		registerPage.completePassword(pass);
		test.pass("User completed password");

		registerPage.clickRegisterBtn2();
		test.pass("User clicked register button");

		test.info("Register Data User Completed");

		try {
			text_alert = registerPage.getAlertText();
			System.out.println("Alert: " + text_alert);
			test.pass("Alert text saved");

			registerPage.acceptAlert();
			test.pass("User acepted alert");

			assertEquals("This user already exist.", text_alert);
			test.pass("Register test OK");
			test.log(Status.INFO, "REGISTER USERNAME EXISTENT TEST COMPLETED SUCCESSFULLY");
			System.out.println("***REGISTER USERNAME EXISTENT TEST COMPLETED SUCCESSFULLY***");
			
		} catch (AssertionError e) {
			test.addScreenCaptureFromPath("screenshot.png");
			test.fail("Register test NO OK");
			test.log(Status.INFO, "REGISTER USERNAME EXISTENT TEST COMPLETED UNSUCCESSFULLY");
			System.out.println("***REGISTER USERNAME EXISTENT TEST COMPLETED UNSUCCESSFULLY***");
		}

	}
	
	@Test(dataProvider = "RegisterUsernameOrPasswordNull", dataProviderClass = Data.class, priority = 3)
	public void registerUsrOrPassNull(String usr, String pass) {
		ExtentTest test = report.createTest("Register Username/Password Null Test");

		test.log(Status.INFO, "REGISTER USERNAME/PASSWORD NULL TEST STARTED SUCCESSFULLY");
		System.out.println("\n***REGISTER USERNAME/PASSWORD NULL TEST STARTED SUCCESSFULLY***");
		
		registerPage.clickRegisterBtn();
		test.pass("User clicked register button");

		registerPage.completeUsername(usr);
		test.pass("User completed username");

		registerPage.completePassword(pass);
		test.pass("User completed password");

		registerPage.clickRegisterBtn2();
		test.pass("User clicked register button");

		test.info("Register Data User Completed");

		try {
			text_alert = registerPage.getAlertText();
			System.out.println("Alert: " + text_alert);
			test.pass("Alert text saved");

			registerPage.acceptAlert();
			test.pass("User acepted alert");

			assertEquals("Please fill out Username and Password.", text_alert);
			test.pass("Register test OK");
			test.log(Status.INFO, "REGISTER USERNAME/PASSWORD NULL TEST COMPLETED SUCCESSFULLY");
			System.out.println("***REGISTER USERNAME/PASSWORD NULL TEST COMPLETED SUCCESSFULLY***");
			
		} catch (AssertionError e) {
			test.addScreenCaptureFromPath("screenshot.png");
			test.fail("Register test NO OK");
			test.log(Status.INFO, "REGISTER USERNAME/PASSWORD NULL TEST COMPLETED UNSUCCESSFULLY");
			System.out.println("***REGISTER USERNAME/PASSWORD NULL TEST COMPLETED UNSUCCESSFULLY***");
		}

	}
	
	@Test(priority = 4)
	public void registerNull() {
		ExtentTest test = report.createTest("Register Null Test");

		test.log(Status.INFO, "REGISTER NULL TEST STARTED SUCCESSFULLY");
		System.out.println("\n***REGISTER NULL TEST STARTED SUCCESSFULLY***");
		
		registerPage.clickRegisterBtn();
		test.pass("User clicked register button");

		registerPage.clickRegisterBtn2();
		test.pass("User clicked register button");

		test.info("Register Data User Not Completed");

		try {
			text_alert = registerPage.getAlertText();
			System.out.println(text_alert);
			test.pass("Alert text saved");

			registerPage.acceptAlert();
			test.pass("User acepted alert");

			assertEquals("Please fill out Username and Password.", text_alert);
			test.pass("Register test OK");
			test.log(Status.INFO, "REGISTER NULL TEST COMPLETED SUCCESSFULLY");
			System.out.println("***REGISTER NULL TEST COMPLETED SUCCESSFULLY***");

		} catch (AssertionError e) {
			test.addScreenCaptureFromPath("screenshot.png");
			test.fail("Register test NO OK");
			test.log(Status.INFO, "REGISTER NULL TEST COMPLETED UNSUCCESSFULLY");
			System.out.println("***REGISTER NULL TEST COMPLETED UNSUCCESSFULLY***");
		}

	}

	// Post-Config
	@AfterMethod
	public void finishTest() {
		report.flush();

		Driver.finish();
	}
}
