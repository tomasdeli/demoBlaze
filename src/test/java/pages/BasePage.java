package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	/*** DRIVER ***/
	public static WebDriver driver;

	/*** CONSTRUCTOR ***/
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** METHODS ***/
	public void navigateTo(String URL) {
		driver.get(URL);
	}

	public void click(WebElement element) {
		if (elementToBeClickable(element) != null) {
			element.click();
		}
	}

	public void type(String text, WebElement element) {
		if (elementVisible(element) != null) {
			element.sendKeys(text);
		}
	}

	public void getText(WebElement element) {
		if (elementVisible(element) != null) {
			element.getText();
		}
	}

	public void switchToFrame(WebElement element) {
		if (elementVisible(element) != null) {
			driver.switchTo().frame(element);
		}
	}

	public Alert switchToAlert() {
		if (alertIsPresent() != null) {
			Alert alert = driver.switchTo().alert();

			return alert;
		} else {
			return null;
		}
	}

	public void acceptAlert(Alert alert) {
		if (alertIsPresent() != null) {
			alert.accept();
		}
	}

	public void cancelAlert(Alert alert) {
		if (alertIsPresent() != null) {
			alert.dismiss();
		}
	}

	public String getAlertText(Alert alert) {
		if (alertIsPresent() != null) {
			return alert.getText();
		}
		return alert.getText();
	}

	public void clear(WebElement element) {
		if (elementVisible(element) != null) {
			element.clear();
		}
	}

	public static ExpectedCondition<WebElement> elementToBeClickable(WebElement element) {
		try {

			new WebDriverWait(driver, java.time.Duration.ofSeconds(5))
					.until(ExpectedConditions.elementToBeClickable(element));

			return ExpectedConditions.elementToBeClickable(element);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return null;
		}
	}

	public static ExpectedCondition<Boolean> elementVisible(WebElement element) {
		try {

			new WebDriverWait(driver, java.time.Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));

			return ExpectedConditions.invisibilityOf(element);
		} catch (Exception e) {
			return null;
		}
	}

	public static ExpectedCondition<Boolean> elementToBeSelected(WebElement element) {
		try {
			new WebDriverWait(driver, java.time.Duration.ofSeconds(5))
					.until(ExpectedConditions.elementToBeSelected(element));

			return ExpectedConditions.elementToBeSelected(element);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return null;

		}
	}

	public static ExpectedCondition<Alert> alertIsPresent() {
		try {
			new WebDriverWait(driver, java.time.Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());

			return ExpectedConditions.alertIsPresent();
		} catch (org.openqa.selenium.NoAlertPresentException e) {
			return null;
		}
	}

	public WebElement getElement(WebElement element) {
		if (elementVisible(element) != null) {
			return element;
		} else {
			return null;
		}
	}
}