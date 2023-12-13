package test_login;

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
import report.Report;

public class Login {
	/*** DRIVER ***/
	private WebDriver driver = null;

	/*** PAGES ***/
	private BasePage basePage = null;
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

		loginPage = new LoginPage();
	}

	// Tests
	@Test(dataProvider = "Login", dataProviderClass = Data.class, priority = 1)
	public void login(String usr, String pass) {
		ExtentTest test = report.createTest("Login Test");
		
		test.log(Status.INFO, "LOGIN TEST STARTED SUCCESSFULLY");
		System.out.println("\n***LOGIN TEST STARTED SUCCESSFULLY***");
		
		loginPage.clickLoginBtn();
		test.pass("User clicked login button");

		loginPage.completeUsername(usr);
		test.pass("User completed username");

		loginPage.completePassword(pass);
		test.pass("User completed password");

		loginPage.clickLoginBtn2();
		test.pass("User clicked login button");

		test.info("Login Data User Completed");

		try {
			test.pass("Welcome text saved");

			assertTrue(loginPage.isWelcomeTxtVisible());
			test.pass("Login test OK");
			test.log(Status.INFO, "LOGIN TEST COMPLETED SUCCESSFULLY");
			System.out.println("***LOGIN TEST COMPLETED SUCCESSFULLY***");

		} catch (AssertionError e) {
			test.addScreenCaptureFromPath("screenshot.png");
			test.fail("Login test NO OK");
			test.log(Status.INFO, "LOGIN TEST COMPLETED UNSUCCESSFULLY");
			System.out.println("***LOGIN TEST COMPLETED UNSUCCESSFULLY***");

		}

	}

	@Test(dataProvider = "LoginUsernameIncorrect", dataProviderClass = Data.class, priority = 2)
	public void loginUsrIncorrect(String usr, String pass) {
		ExtentTest test = report.createTest("Login Username Incorrect Test");

		test.log(Status.INFO, "LOGIN USERNAME INCORRECT TEST STARTED SUCCESSFULLY");
		System.out.println("\n***LOGIN USERNAME INCORRECT TEST STARTED***");
		
		loginPage.clickLoginBtn();
		test.pass("User clicked login button");

		loginPage.completeUsername(usr);
		test.pass("User completed username");

		loginPage.completePassword(pass);
		test.pass("User completed password");

		loginPage.clickLoginBtn2();
		test.pass("User clicked login button");

		test.info("Login Data User Completed");

		try {
			text_alert = loginPage.getAlertText();
			System.out.println("Alert: " + text_alert);
			test.pass("Alert text saved");

			loginPage.acceptAlert();
			test.pass("User acepted alert");

			assertEquals("User does not exist.", text_alert);
			test.pass("Login test OK");
			test.log(Status.INFO, "LOGIN USERNAME INCORRECT TEST COMPLETED SUCCESSFULLY");
			System.out.println("***LOGIN USERNAME INCORRECT TEST COMPLETED SUCCESSFULLY***");

		} catch (AssertionError e) {
			test.addScreenCaptureFromPath("screenshot.png");
			test.fail("Login test NO OK");
			test.log(Status.INFO, "LOGIN USERNAME INCORRECT TEST COMPLETED UNSUCCESSFULLY");
			System.out.println("***LOGIN USERNAME INCORRECT TEST COMPLETED UNSUCCESSFULLY***");
		}

	}
	
	@Test(dataProvider = "LoginPasswordIncorrect", dataProviderClass = Data.class, priority = 3)
	public void loginPassIncorrect(String usr, String pass) {
		ExtentTest test = report.createTest("Login Password Incorrect Test");

		test.log(Status.INFO, "LOGIN PASSWORD INCORRECT TEST STARTED SUCCESSFULLY");
		System.out.println("\n***LOGIN PASSWORD INCORRECT TEST STARTED SUCCESSFULLY***");
		
		loginPage.clickLoginBtn();
		test.pass("User clicked login button");

		loginPage.completeUsername(usr);
		test.pass("User completed username");

		loginPage.completePassword(pass);
		test.pass("User completed password");

		loginPage.clickLoginBtn2();
		test.pass("User clicked login button");

		test.info("Login Data User Completed");

		try {
			text_alert = loginPage.getAlertText();
			System.out.println("Alert: " + text_alert);
			test.pass("Alert text saved");

			loginPage.acceptAlert();
			test.pass("User acepted alert");

			assertEquals("Wrong password.", text_alert);
			test.pass("Login test OK");
			test.log(Status.INFO, "LOGIN PASSWORD INCORRECT TEST COMPLETED SUCCESSFULLY");
			System.out.println("***LOGIN PASSWORD INCORRECT TEST COMPLETED SUCCESSFULLY***");

		} catch (AssertionError e) {
			test.addScreenCaptureFromPath("screenshot.png");
			test.fail("Login test NO OK");
			test.log(Status.INFO, "LOGIN PASSWORD INCORRECT TEST COMPLETED UNSUCCESSFULLY");
			System.out.println("***LOGIN PASSWORD INCORRECT TEST COMPLETED UNSUCCESSFULLY***");
		}

	}

	@Test(dataProvider = "LoginUsernameOrPasswordNull", dataProviderClass = Data.class, priority = 4)
	public void loginUsrOrPassNull(String usr, String pass) {
		ExtentTest test = report.createTest("Login Username/Password Null Test");

		test.log(Status.INFO, "LOGIN USERNAME/PASSWORD NULL TEST STARTED SUCCESSFULLY");
		System.out.println("\n***LOGIN USERNAME/PASSWORD NULL TEST STARTED SUCCESSFULLY***");
		
		loginPage.clickLoginBtn();
		test.pass("User clicked login button");

		loginPage.completeUsername(usr);
		test.pass("User completed username");

		loginPage.completePassword(pass);
		test.pass("User completed password");

		loginPage.clickLoginBtn2();
		test.pass("User clicked login button");

		test.info("Login Data User Completed");

		try {
			text_alert = loginPage.getAlertText();
			System.out.println("Alert: " + text_alert);
			test.pass("Alert text saved");

			loginPage.acceptAlert();
			test.pass("User acepted alert");

			assertEquals("Please fill out Username and Password.", text_alert);
			test.pass("Login test OK");
			test.log(Status.INFO, "LOGIN USERNAME/PASSWORD NULL TEST COMPLETED SUCCESSFULLY");
			System.out.println("***LOGIN USERNAME/PASSWORD NULL TEST COMPLETED SUCCESSFULLY***");

		} catch (AssertionError e) {
			test.addScreenCaptureFromPath("screenshot.png");
			test.fail("Login test NO OK");
			test.log(Status.INFO, "LOGIN USERNAME/PASSWORD NULL TEST COMPLETED UNSUCCESSFULLY");
			System.out.println("***LOGIN USERNAME/PASSWORD NULL TEST COMPLETED UNSUCCESSFULLY***");
		}

	}
	
	@Test(priority = 5)
	public void loginNull() {
		ExtentTest test = report.createTest("Login Null Test");

		test.log(Status.INFO, "LOGIN NULL TEST STARTED SUCCESSFULLY");
		System.out.println("\n***LOGIN NULL TEST STARTED SUCCESSFULLY***");

		loginPage.clickLoginBtn();
		test.pass("User clicked login button");

		loginPage.clickLoginBtn2();
		test.pass("User clicked login button");

		test.info("Login Data User Not Completed");

		try {
			text_alert = loginPage.getAlertText();
			System.out.println("Alert: " + text_alert);
			test.pass("Alert text saved");

			loginPage.acceptAlert();
			test.pass("User acepted alert");

			assertEquals("Please fill out Username and Password.", text_alert);
			test.pass("Login test OK");
			test.log(Status.INFO, "LOGIN NULL TEST COMPLETED SUCCESSFULLY");
			System.out.println("***LOGIN NULL TEST COMPLETED SUCCESSFULLY***");

		} catch (AssertionError e) {
			test.addScreenCaptureFromPath("screenshot.png");
			test.fail("Login test NO OK");
			test.log(Status.INFO, "LOGIN NULL TEST COMPLETED UNSUCCESSFULLY");
			System.out.println("***LOGIN NULL TEST COMPLETED UNSUCCESSFULLY***");
		}

	}

	// Post-Config
	@AfterMethod
	public void finishTest() {
		report.flush();

		Driver.finish();
	}
}