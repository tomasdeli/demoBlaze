package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	/*** LOCATORS ***/
	@FindBy(id = "signin2")
	private WebElement register_btn;
	@FindBy(id = "sign-username")
	private WebElement usr_fld;
	@FindBy(id = "sign-password")
	private WebElement pass_fld;
	@FindBy(xpath = "//button[@onclick=\"register()\"]")
	private WebElement register_btn_2;

	/*** VARIABLES ***/
	private boolean isVisible = false;

	/*** CONSTRUCTOR ***/
	public RegisterPage() {
		super(driver);
	}

	/*** METHODS ***/

	// Register
	public void clickRegisterBtn() {
		click(register_btn);
	}

	public void completeUsername(String username) {
		type(username, usr_fld);
	}

	public void completePassword(String password) {
		type(password, pass_fld);
	}

	public void clickRegisterBtn2() {
		click(register_btn_2);
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
	public boolean isRegisterBtnVisible() {
		if (elementVisible(register_btn) != null) {
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

	public boolean isRegisterBtn2Visible() {
		if (elementVisible(register_btn_2) != null) {
			isVisible = true;
		}

		return isVisible;
	}
}