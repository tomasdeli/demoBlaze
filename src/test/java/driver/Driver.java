package driver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
	/*** DRIVER ***/
	private static WebDriver driver;

	/*** LOGGER ***/
	private static Logger logger = LogManager.getLogger(Driver.class);

	/*** METHODS ***/
	// Driver configuration
	public static WebDriver configurate() {
		logger.info("Driver Configuration Started");

		logger.info("Searching Driver");
		// WINDOWS
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver/119/chromedriver.exe");

		// LINUX
		// System.setProperty("webdriver.chrome.driver",
		// "src/test/resources/driver/chromedriver/119/chromedriver");

		logger.info("ChromeOptions Configuration Started");
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");

		logger.info("ChromeOptions Configuration Terminated");

		driver = new ChromeDriver(options);

		logger.info("Driver Configuration Terminated");

		return driver;

	}

	// Finish connection
	public static void finish() {
		logger.info("Driver close");
		driver.close();
		driver.quit();

		logger.info("Driver quit");
	}
}