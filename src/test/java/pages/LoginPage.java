package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	/*** LOCATORS ***/
	@FindBy(id = "login2")
	private WebElement login_btn;
	@FindBy(id = "loginusername")
	private WebElement usr_fld;
	@FindBy(id = "loginpassword")
	private WebElement pass_fld;
	@FindBy(xpath = "//button[@onclick=\"logIn()\"]")
	private WebElement login_btn_2;
	@FindBy(id = "nameofuser")
	private WebElement welcome_txt;

	/*** VARIABLES ***/
	private boolean isVisible = false;

	/*** CONSTRUCTOR ***/
	public LoginPage() {
		super(driver);
	}

	/*** METHODS ***/

	// Login
	public void clickLoginBtn() {
		click(login_btn);
	}

	public void completeUsername(String username) {
		type(username, usr_fld);
	}

	public void completePassword(String password) {
		type(password, pass_fld);
	}

	public void clickLoginBtn2() {
		click(login_btn_2);
	}

	// Alerts
	public void acceptAlert() {
		Alert alert = switchToAlert();

		acceptAlert(alert);
	}

	public void cancelAlert() {
		Alert alert = switchToAlert();

		cancelAlert(alert);
	}

	public String getAlertText() {
		Alert alert = switchToAlert();

		return getAlertText(alert);
	}

	// Visible
	public boolean isLoginBtnVisible() {
		if (elementVisible(login_btn) != null) {
			isVisible = true;
		}

		return isVisible;
	}

	public boolean isUsrFldVisible() {
		if (elementVisible(usr_fld) != null) {
			isVisible = true;
		}

		return isVisible;
	}

	public boolean isPassFldVisible() {
		if (elementVisible(pass_fld) != null) {
			isVisible = true;
		}

		return isVisible;
	}

	public boolean isLoginBtn2Visible() {
		if (elementVisible(login_btn_2) != null) {
			isVisible = true;
		}

		return isVisible;
	}

	public boolean isWelcomeTxtVisible() {
		if (elementVisible(welcome_txt) != null) {
			isVisible = true;
		}

		return isVisible;
	}
}